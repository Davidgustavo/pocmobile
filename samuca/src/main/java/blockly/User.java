package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class User {

public static final int TIMEOUT = 300;

/**
 *
 * @param filtro
 * @return Var
 */
// Descreva esta função...
public static Var getUsers(Var filtro) throws Exception {
 return new Callable<Var>() {

   private Var userList = Var.VAR_NULL;
   private Var users = Var.VAR_NULL;
   private Var userName = Var.VAR_NULL;
   private Var userId = Var.VAR_NULL;
   private Var exception = Var.VAR_NULL;

   public Var call() throws Exception {
    userList = cronapi.list.Operations.newList();
    try {
         users = cronapi.list.Operations.newList();
        userName = cronapi.util.Operations.getCurrentUserName();
        userId = blockly.Chat.getIdUserLogged(userName);
        if (cronapi.logic.Operations.isNullOrEmpty(filtro).negate().getObjectAsBoolean()) {
            users = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("SELECT u from User u \nwhere lower(u.name) LIKE (CONCAT(\'%\', lower(:filtro), \'%\')) and u.id <> :id \nORDER BY u.name ASC"),Var.valueOf("filtro",filtro),Var.valueOf("id",userId));
        } else {
            users = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("SELECT u from User u \nwhere u.id <> :id \nORDER BY u.name ASC"),Var.valueOf("id",userId));
        }
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);
         System.out.println(Var.valueOf(Var.valueOf("User.getUsers: ").toString() + exception.toString()).getObjectAsString());
     }
    return users;
   }
 }.call();
}

}

