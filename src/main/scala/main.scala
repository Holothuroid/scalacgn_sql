import java.sql._

implicit val con : Connection = ???

val user = 7

sql"select * from USERS where username = $user"



trait ToSql {
  
  def apply(stelle: Int, preparedStatment: PreparedStatement) : Unit
}

implicit class Int2Sql(i: Int) extends ToSql{
  def apply(stelle : Int, preparedStatement : PreparedStatement)
  = preparedStatement.setInt(stelle, i) 
  
}



implicit class MyContextOps (sc: StringContext){
  
  
  
  
  
  
  def sql(args : ToSql*)(implicit con: Connection) : PreparedStatement = {
    
   val statement = sc.s(args.map(_ => " ? "))
    
    val preparedStatement = con.prepareStatement(statement)
    args.zipWithIndex.foreach{ case (arg,index) => arg(index,preparedStatement) }
    preparedStatement
  
    
  }

  
}

