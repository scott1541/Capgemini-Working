import com.mongodb.casbah.Imports._

case class MilesPG (miles: Double, litres: Double)

object Common {
  /**
    * Convert a Stock object into a BSON format that MongoDb can store.
    */
  def buildMongoDbObject(milespg: MilesPG): MongoDBObject = {
    val builder = MongoDBObject.newBuilder
    builder += "miles" -> milespg.miles
    builder += "litres" -> milespg.litres
    builder.result
  }
}
