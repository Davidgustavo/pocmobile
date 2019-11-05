window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.chat = window.blockly.js.blockly.chat || {};
window.blockly.js.blockly.chat.GoChat = window.blockly.js.blockly.chat.GoChat || {};

/**
 * GoChat
 */
window.blockly.js.blockly.chat.GoChat.Execute = function(contactId, groupId) {
 var item, groupName;
  this.cronapi.screen.changeView("#/app/logged/chat",[ { contactId : contactId } , { groupId : groupId } ]);
}

/**
 * GoChat
 */
window.blockly.js.blockly.chat.GoChat.GoGroup = function(groupId, groupName) {
 var item, contactId;
  this.cronapi.screen.changeView("#/app/logged/grupo",[ { groupId : groupId } , { groupName : groupName } ]);
}
