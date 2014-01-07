package code.model

//for db
import net.liftweb.mongodb._
import net.liftweb.mongodb.record._
import net.liftweb.mongodb.record.field._
import net.liftweb.record.field.{ IntField , StringField, EnumField }
//for queries
import com.foursquare.rogue.LiftRogue._

class User private() extends MongoRecord[User] with ObjectIdPk[User] {
  def meta = User

  object name extends StringField(this, 12)
  object surname extends StringField(this, 12)
  object yob extends IntField(this)
  object gender extends EnumField(this, Gender)
}

object User extends User with MongoMetaRecord[User] {
  
}

object Gender extends Enumeration {
  type Ggender = Value
  val M, F, Unknown = Value
}