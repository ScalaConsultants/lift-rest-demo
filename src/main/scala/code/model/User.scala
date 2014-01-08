package code.model

//for db
import net.liftweb.mongodb._
import net.liftweb.mongodb.record._
import net.liftweb.mongodb.record.field._
import net.liftweb.record.field.{ IntField , StringField, EnumField }
import com.foursquare.rogue.LiftRogue._
import net.liftweb.common.Logger

class User private() extends MongoRecord[User] with ObjectIdPk[User] with Logger {
  def meta = User

  object name extends StringField(this, 12)
  object surname extends StringField(this, 12)
  object yob extends IntField(this)
  object gender extends EnumField(this, Gender)
}

object User extends User with MongoMetaRecord[User] {
  def sameAge(expectedYob: Int): List[User] = {
    User.where(_.yob eqs expectedYob).fetch()
  }
}

object Gender extends Enumeration {
  type Ggender = Value
  val M, F, Unknown = Value
}