window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Group = window.blockly.js.blockly.Group || {};
window.blockly.js.blockly.Group.Group = window.blockly.js.blockly.Group.Group || {};

/**
 * Group
 */
window.blockly.js.blockly.Group.Group.createGroup = function(groupName) {
 var item, conversation, event, filter, flag, groupId, user;
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Group:create', function(sender_groupId) {
      groupId = sender_groupId;
    if (groupId != null) {
      this.cronapi.screen.changeView("#/app/logged/user",[ { groupId : groupId } ]);
    } else {
      this.cronapi.screen.notify('error',String('Erro ao criar grupo: ') + String(groupName));
    }
  }.bind(this), groupName);
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Group.Group.goAddUser = function(groupId) {
 var item, conversation, event, filter, flag, groupName, user;
  this.cronapi.screen.changeView("#/app/logged/user",[ { groupId : groupId } ]);
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Group.Group.addUserGroup = function(event, groupId, user) {
 var item, conversation, filter, flag, groupName;
  this.cronapi.myfunctions.stopPropagation(event);
  this.cronapi.object.setProperty(user, 'add', true);
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Group:addUserGroup', function(sender_flag) {
      flag = sender_flag;
    this.cronapi.object.setProperty(user, 'add', flag);
  }.bind(this), groupId, this.cronapi.json.getProperty(user, 'id'));
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Group.Group.removeUserGroup = function(event, groupId, user) {
 var item, conversation, filter, flag, groupName;
  this.cronapi.myfunctions.stopPropagation(event);
  this.cronapi.object.setProperty(user, 'add', false);
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Group:removeUserGroup', function(sender_flag) {
      flag = sender_flag;
    this.cronapi.object.setProperty(user, 'add', flag);
  }.bind(this), groupId, this.cronapi.json.getProperty(user, 'id'));
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Group.Group.filterElement = function(conversation, filter) {
 var item, event, flag, groupId, groupName, user;
  return this.cronapi.myfunctions.filterConversation(conversation, filter);
}
