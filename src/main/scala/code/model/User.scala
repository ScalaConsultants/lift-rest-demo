package code.model

import net.liftweb.mongodb._
import net.liftweb.mongodb.record._
import net.liftweb.mongodb.record.field._
import net.liftweb.record.field.{ IntField , StringField }

class User private() extends MongoRecord[User] with ObjectIdPk[User] {
  def meta = User

  object name extends StringField(this, 12)
  object yob extends IntField(this)
}

object User extends User with MongoMetaRecord[User]