import com.mongodb.casbah.Imports._
import Common._

object Insert extends App {

  // create some Stock instances
  val apple = MilesPG(234, 29.54)


  saveStock(apple)


  // our 'save' method
  def saveMPG(milespg: MilesPG) {
    val mongoObj = buildMongoDbObject(milespg)
    MongoFactory.collection.save(mongoObj)
  }

}