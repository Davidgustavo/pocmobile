package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Chat {

public static final int TIMEOUT = 300;

/**
 *
 * @param param_groupId
 * @param contactId
 * @return Var
 */
// Chat
public static Var findMessages(Var param_groupId, Var contactId) throws Exception {
 return new Callable<Var>() {

   // param
   private Var groupId = param_groupId;
   // end
   private Var userName = Var.VAR_NULL;
   private Var userId = Var.VAR_NULL;
   private Var exception = Var.VAR_NULL;
   private Var messages = Var.VAR_NULL;

   public Var call() throws Exception {
    messages = Var.VAR_NULL;
    try {
         userName = cronapi.util.Operations.getCurrentUserName();
        userId = Var.valueOf(getIdUserLogged(userName));
        if (Var.valueOf(groupId.equals(Var.valueOf(-1))).getObjectAsBoolean()) {
            groupId = Var.valueOf(getGroupId(userId, contactId));
        }
        messages = blockly.Chat.findMessagesGroup(groupId);
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);
         System.out.println(Var.valueOf(Var.valueOf("Chat.findMessage: ").toString() + exception.toString()).getObjectAsString());
     }
    return messages;
   }
 }.call();
}

/**
 *
 * @param userId
 * @param contactId
 * @return Var
 */
// Descreva esta função...
public static Var createGroup(Var userId, Var contactId) throws Exception {
 return new Callable<Var>() {

   private Var groupId = Var.VAR_NULL;
   private Var exception = Var.VAR_NULL;
   private Var group = Var.VAR_NULL;

   public Var call() throws Exception {
    groupId = Var.VAR_NULL;
    try {
         group = cronapi.object.Operations.newObject(Var.valueOf("app.entity.Group"),Var.valueOf("user",userId),Var.valueOf("contact",contactId));
        cronapi.database.Operations.insert(Var.valueOf("app.entity.Group"),group);
        groupId = cronapi.object.Operations.getObjectField(group, Var.valueOf("id"));
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);
         System.out.println(Var.valueOf(Var.valueOf("Chat.createGroupIfNotExists: ").toString() + exception.toString()).getObjectAsString());
     }
    return groupId;
   }
 }.call();
}

/**
 *
 * @param groupId
 * @return Var
 */
// Descreva esta função...
public static Var findMessagesGroup(Var groupId) throws Exception {
 return new Callable<Var>() {

   private Var message = Var.VAR_NULL;
   private Var exception = Var.VAR_NULL;
   private Var messages = Var.VAR_NULL;
   private Var messagesResult = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;

   public Var call() throws Exception {
    messages = cronapi.list.Operations.newList();
    try {
         messagesResult = cronapi.database.Operations.query(Var.valueOf("app.entity.Message"),Var.valueOf("select m.id,  m.user.name, m.user.id, m.message, m.user.login, m.user.picture from Message m where m.group.id = :groupId"),Var.valueOf("groupId",groupId));
        for (Iterator it_i = messagesResult.iterator(); it_i.hasNext();) {
            i = Var.valueOf(it_i.next());
            message = cronapi.object.Operations.newObject(Var.valueOf("app.entity.MessageDetails"),Var.valueOf("id",cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(1))),Var.valueOf("userName",cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(2))),Var.valueOf("userId",cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(3))),Var.valueOf("message",cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(4))),Var.valueOf("login",cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(5))),Var.valueOf("userImage",cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(6))));
            cronapi.list.Operations.addLast(messages,message);
        } // end for
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);
         System.out.println(Var.valueOf(Var.valueOf("Group.findMessagesGroup: ").toString() + exception.toString()).getObjectAsString());
     }
    return messages;
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var getConversations() throws Exception {
 return new Callable<Var>() {

   private Var userName = Var.VAR_NULL;
   private Var userId = Var.VAR_NULL;
   private Var message = Var.VAR_NULL;
   private Var exception = Var.VAR_NULL;
   private Var messages = Var.VAR_NULL;
   private Var result = Var.VAR_NULL;
   private Var groups = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;

   public Var call() throws Exception {
    groups = cronapi.list.Operations.newList();
    try {
         userName = cronapi.util.Operations.getCurrentUserName();
        userId = Var.valueOf(getIdUserLogged(userName));
        result = cronapi.database.Operations.query(Var.valueOf("app.entity.Group"),Var.valueOf("select g.id, g.user.id, g.user.login, g.user.name, g.contact.id, g.contact.login, g.contact.name , g.user.picture, g.contact.picture \nfrom Group g  where g.user.id = :userId OR g.contact.id = :contactId \ngroup by g.id"),Var.valueOf("userId",userId),Var.valueOf("contactId",userId));
        for (Iterator it_j = result.iterator(); it_j.hasNext();) {
            j = Var.valueOf(it_j.next());
            messages = cronapi.database.Operations.query(Var.valueOf("app.entity.Message"),Var.valueOf("select m.message, m.group.id from Message m where m.group.id = :groupId order by m.sendDate desc"),Var.valueOf("groupId",cronapi.list.Operations.get((cronapi.json.Operations.toJson(j)), Var.valueOf(1))));
            message = Var.VAR_NULL;
            if (cronapi.logic.Operations.isNullOrEmpty(messages).negate().getObjectAsBoolean()) {
                message = cronapi.list.Operations.get((cronapi.json.Operations.toJson(cronapi.list.Operations.getFirst(messages))), Var.valueOf(1));
                cronapi.list.Operations.addLast(groups,cronapi.object.Operations.newObject(Var.valueOf("app.entity.ConversationDetails"),Var.valueOf("id",cronapi.list.Operations.get((cronapi.json.Operations.toJson(j)), Var.valueOf(1))),Var.valueOf("userId",cronapi.list.Operations.get((cronapi.json.Operations.toJson(j)), Var.valueOf(2))),Var.valueOf("userName",cronapi.list.Operations.get((cronapi.json.Operations.toJson(j)), Var.valueOf(4))),Var.valueOf("userLogin",cronapi.list.Operations.get((cronapi.json.Operations.toJson(j)), Var.valueOf(3))),Var.valueOf("contactId",cronapi.list.Operations.get((cronapi.json.Operations.toJson(j)), Var.valueOf(5))),Var.valueOf("contactName",cronapi.list.Operations.get((cronapi.json.Operations.toJson(j)), Var.valueOf(7))),Var.valueOf("contactLogin",cronapi.list.Operations.get((cronapi.json.Operations.toJson(j)), Var.valueOf(6))),Var.valueOf("message",message),Var.valueOf("userImage",cronapi.list.Operations.get((cronapi.json.Operations.toJson(j)), Var.valueOf(8))),Var.valueOf("contactImage",cronapi.list.Operations.get((cronapi.json.Operations.toJson(j)), Var.valueOf(9)))));
            }
        } // end for
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);
         System.out.println(Var.valueOf(Var.valueOf("Chat.getConversations: ").toString() + exception.toString()).getObjectAsString());
     }
    return groups;
   }
 }.call();
}

/**
 *
 * @param userId
 * @param contactId
 * @return Var
 */
// Descreva esta função...
public static Var getGroupId(Var userId, Var contactId) throws Exception {
 return new Callable<Var>() {

   private Var groupId = Var.VAR_NULL;
   private Var exception = Var.VAR_NULL;
   private Var result = Var.VAR_NULL;

   public Var call() throws Exception {
    groupId = Var.VAR_NULL;
    try {
         result = cronapi.database.Operations.query(Var.valueOf("app.entity.Group"),Var.valueOf("select g.id from Group g where ( g.user.id = :userId AND g.contact.id = :contactId ) OR  \n( g.user.id = :userId2 AND g.contact.id = :contactId2 )"),Var.valueOf("userId",userId),Var.valueOf("contactId",contactId),Var.valueOf("userId2",contactId),Var.valueOf("contactId2",userId));
        if (cronapi.logic.Operations.isNullOrEmpty(result).negate().getObjectAsBoolean()) {
            groupId = cronapi.list.Operations.getFirst(result);
        } else {
            groupId = Var.valueOf(createGroup(userId, contactId));
        }
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);
         System.out.println(Var.valueOf(Var.valueOf("Chat.getGroupId").toString() + exception.toString()).getObjectAsString());
     }
    return groupId;
   }
 }.call();
}

/**
 *
 * @param name
 * @return Var
 */
// Descreva esta função...
public static Var getIdUserLogged(Var name) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return cronapi.list.Operations.getFirst((cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select u.id from User u where lower(u.login) = lower(:login)"),Var.valueOf("login",name))));
   }
 }.call();
}

/**
 *
 * @param message
 * @param groupId
 * @return Var
 */
// Descreva esta função...
public static Var sendMessageGroup(Var message, Var groupId) throws Exception {
 return new Callable<Var>() {

   private Var userName = Var.VAR_NULL;
   private Var userId = Var.VAR_NULL;
   private Var exception = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         userName = cronapi.util.Operations.getCurrentUserName();
        userId = blockly.Chat.getIdUserLogged(userName);
        cronapi.database.Operations.insert(Var.valueOf("app.entity.Message"),Var.valueOf("message",message),Var.valueOf("user",userId),Var.valueOf("group",groupId));
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);
         System.out.println(Var.valueOf(Var.valueOf("Chat.sendMessageGroup: ").toString() + exception.toString()).getObjectAsString());
     }
    return Var.VAR_TRUE;
   }
 }.call();
}

/**
 *
 * @param contactId
 * @param param_groupId
 * @param message
 * @return Var
 */
// Descreva esta função...
public static Var sendMessages(Var contactId, Var param_groupId, Var message) throws Exception {
 return new Callable<Var>() {

   // param
   private Var groupId = param_groupId;
   // end
   private Var userName = Var.VAR_NULL;
   private Var userId = Var.VAR_NULL;
   private Var exception = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         userName = cronapi.util.Operations.getCurrentUserName();
        userId = Var.valueOf(getIdUserLogged(userName));
        if (Var.valueOf(groupId.equals(Var.valueOf(-1))).getObjectAsBoolean()) {
            groupId = Var.valueOf(getGroupId(userId, contactId));
        }
        cronapi.database.Operations.insert(Var.valueOf("app.entity.Message"),Var.valueOf("message",message),Var.valueOf("user",userId),Var.valueOf("group",groupId));
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);
         System.out.println(Var.valueOf(Var.valueOf("Chat.sendMessage: ").toString() + exception.toString()).getObjectAsString());
     }
    return Var.VAR_TRUE;
   }
 }.call();
}

}

