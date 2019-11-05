package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Group {

public static final int TIMEOUT = 300;

/**
 *
 * @param groupName
 * @return Var
 */
// Group
public static Var create(Var groupName) throws Exception {
 return new Callable<Var>() {

   private Var groupId = Var.VAR_NULL;
   private Var group = Var.VAR_NULL;
   private Var userId = Var.VAR_NULL;
   private Var exception = Var.VAR_NULL;

   public Var call() throws Exception {
    groupId = Var.VAR_NULL;
    try {
         group = cronapi.object.Operations.newObject(Var.valueOf("app.entity.Group"),Var.valueOf("name",groupName));
        cronapi.database.Operations.insert(Var.valueOf("app.entity.Group"),group);
        groupId = cronapi.object.Operations.getObjectField(group, Var.valueOf("id"));
        userId = cronapi.list.Operations.getFirst((cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select u.id from User u where u.name = :name"),Var.valueOf("name",cronapi.util.Operations.getCurrentUserName()))));
        cronapi.database.Operations.insert(Var.valueOf("app.entity.UserGroup"),cronapi.object.Operations.newObject(Var.valueOf("app.entity.UserGroup"),Var.valueOf("user",userId),Var.valueOf("group",groupId)));
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);
         System.out.println(Var.valueOf(Var.valueOf("Group.create:").toString() + exception.toString()).getObjectAsString());
     }
    return groupId;
   }
 }.call();
}

/**
 *
 * @param groupId
 * @param userId
 * @return Var
 */
// Descreva esta função...
public static Var addUserGroup(Var groupId, Var userId) throws Exception {
 return new Callable<Var>() {

   private Var exception = Var.VAR_NULL;
   private Var flag = Var.VAR_NULL;

   public Var call() throws Exception {
    flag = Var.VAR_FALSE;
    try {
         cronapi.database.Operations.insert(Var.valueOf("app.entity.UserGroup"),cronapi.object.Operations.newObject(Var.valueOf("app.entity.UserGroup"),Var.valueOf("user",userId),Var.valueOf("group",groupId)));
        flag = Var.VAR_TRUE;
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);
         System.out.println(Var.valueOf(Var.valueOf("Group.addUserGroup: ").toString() + exception.toString()).getObjectAsString());
     }
    return flag;
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var getGroups() throws Exception {
 return new Callable<Var>() {

   private Var group = Var.VAR_NULL;
   private Var userId = Var.VAR_NULL;
   private Var exception = Var.VAR_NULL;
   private Var username = Var.VAR_NULL;

   public Var call() throws Exception {
    group = Var.VAR_NULL;
    try {
         username = cronapi.util.Operations.getCurrentUserName();
        userId = blockly.Chat.getIdUserLogged(username);
        group = cronapi.database.Operations.query(Var.valueOf("app.entity.UserGroup"),Var.valueOf("select u.group from UserGroup u where u.user.id = :userId"),Var.valueOf("userId",userId));
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);
         System.out.println(Var.valueOf(Var.valueOf("Group.getGroups: ").toString() + exception.toString()).getObjectAsString());
     }
    return group;
   }
 }.call();
}

/**
 *
 * @param groupId
 * @param filtro
 * @return Var
 */
// Descreva esta função...
public static Var getUsers(Var groupId, Var filtro) throws Exception {
 return new Callable<Var>() {

   private Var exception = Var.VAR_NULL;
   private Var flag = Var.VAR_NULL;
   private Var userList = Var.VAR_NULL;
   private Var users = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;

   public Var call() throws Exception {
    userList = cronapi.list.Operations.newList();
    try {
         users = cronapi.list.Operations.newList();
        if (cronapi.logic.Operations.isNullOrEmpty(filtro).negate().getObjectAsBoolean()) {
            users = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("SELECT u.id, u.name, \n(select CASE WHEN count(ug) > 0 THEN 1 ELSE 0 END from UserGroup ug where ug.group.id = :groupId and ug.user.id = u.id) as add,\nu.login, u.picture  \nfrom User u \nwhere lower(u.name) LIKE (CONCAT(\'%\', lower(:filtro), \'%\')) \nORDER BY add DESC , u.name ASC"),Var.valueOf("groupId",groupId),Var.valueOf("filtro",filtro));
        } else {
            users = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("SELECT u.id, u.name, \n(select CASE WHEN count(ug) > 0 THEN 1 ELSE 0 END from UserGroup ug where ug.group.id = :groupId and ug.user.id = u.id) as add,\nu.login, u.picture  \nfrom User u \nORDER BY add DESC , u.name ASC"),Var.valueOf("groupId",groupId));
        }
        for (Iterator it_i = users.iterator(); it_i.hasNext();) {
            i = Var.valueOf(it_i.next());
            flag = Var.valueOf(cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(3)).compareTo(Var.valueOf(0)) > 0);
            cronapi.list.Operations.addLast(userList,cronapi.object.Operations.newObject(Var.valueOf("app.entity.UserDetails"),Var.valueOf("id",cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(1))),Var.valueOf("name",cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(2))),Var.valueOf("login",cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(4))),Var.valueOf("add",flag),Var.valueOf("picture",cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(5)))));
        } // end for
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);
         System.out.println(Var.valueOf(Var.valueOf("Group.getUsers: ").toString() + exception.toString()).getObjectAsString());
     }
    return userList;
   }
 }.call();
}

/**
 *
 * @param groupId
 * @param userId
 * @return Var
 */
// Descreva esta função...
public static Var removeUserGroup(Var groupId, Var userId) throws Exception {
 return new Callable<Var>() {

   private Var group = Var.VAR_NULL;
   private Var exception = Var.VAR_NULL;
   private Var flag = Var.VAR_NULL;

   public Var call() throws Exception {
    flag = Var.VAR_TRUE;
    try {
         cronapi.database.Operations.execute(Var.valueOf("app.entity.UserGroup"), Var.valueOf("delete from UserGroup where group = :group AND user = :user"),Var.valueOf("group",groupId),Var.valueOf("user",userId));
        flag = Var.VAR_FALSE;
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);
         System.out.println(Var.valueOf(Var.valueOf("Group.removeUserGroup: ").toString() + exception.toString()).getObjectAsString());
     }
    return flag;
   }
 }.call();
}

}

