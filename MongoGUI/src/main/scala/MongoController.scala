import scala.concurrent.{ ExecutionContext, Future }

import reactivemongo.api.{ DefaultDB, MongoConnection, MongoDriver }
import reactivemongo.bson.{
BSONDocumentWriter, BSONDocumentReader, Macros, document
}

object MongoController {
  // My settings (see available connection options)
  val mongoUri = "mongodb://localhost:27017/mydb?authMode=scram-sha1"

  import ExecutionContext.Implicits.global // use any appropriate context

  // Connect to the database: Must be done only once per application
  val driver = MongoDriver()
  val parsedUri = MongoConnection.parseURI(mongoUri)
  val connection = parsedUri.map(driver.connection(_))

  // Database and collections: Get references
  val futureConnection = Future.fromTry(connection)
  def db1: Future[DefaultDB] = futureConnection.flatMap(_.database("mpgdb"))
  def db2: Future[DefaultDB] = futureConnection.flatMap(_.database("mpgdb2"))
  def mpgCollection = db1.map(_.collection("mpg"))

  // Write Documents: insert or update

  implicit def mpgWriter: BSONDocumentWriter[MilesPG] = Macros.writer[MilesPG]
  // or provide a custom one

  def createPerson(person: MilesPG): Future[Unit] =
    mpgCollection.flatMap(_.insert(person).map(_ => {})) // use personWriter

  def updatePerson(person: MilesPG): Future[Int] = {
    val selector = document(
      "miles" -> person.miles,
      "fuel" -> person.fuel
    )

    // Update the matching person
    mpgCollection.flatMap(_.update(selector, person).map(_.n))
  }

  implicit def personReader: BSONDocumentReader[MilesPG] = Macros.reader[MilesPG]
  // or provide a custom one

  def findPersonByAge(age: Int): Future[List[MilesPG]] =
    mpgCollection.flatMap(_.find(document("age" -> age)). // query builder
      cursor[MilesPG]().collect[List]()) // collect using the result cursor
  // ... deserializes the document using personReader

  // Custom persistent types
  case class MilesPG(miles: Double, fuel: Double)
}