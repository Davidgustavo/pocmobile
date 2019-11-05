window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.chat = window.blockly.js.blockly.chat || {};
window.blockly.js.blockly.chat.Chat = window.blockly.js.blockly.chat.Chat || {};

/**
 * Chat
 */
window.blockly.js.blockly.chat.Chat.sendMessage = function(message, contactId, groupId) {
 var item;
  if (message) {
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.Chat:sendMessages', function(sender_item) {
        item = sender_item;
      this.cronapi.myfunctions.scroll('.chatListMessages');
    }.bind(this), contactId, groupId, message);
    this.cronapi.screen.changeValueOfField("vars.message", '');
  }
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.chat.Chat.scrollBottom = function() {
 var item, contactId, groupId, message;
  this.cronapi.myfunctions.scroll('.chatListMessages');
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.chat.Chat.sendMessageGroup = function(message, groupId) {
 var item, contactId;
  if (message) {
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.Chat:sendMessageGroup', function(sender_item) {
        item = sender_item;
      this.cronapi.myfunctions.scroll('.chatListMessages');
    }.bind(this), message, groupId);
    this.cronapi.screen.changeValueOfField("vars.message", '');
  }
}
