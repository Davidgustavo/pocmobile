(function() {
  'use strict';

  this.cronapi = this.cronapi || {};

   /**
   * @categoryName Utils
   */
  this.cronapi.myfunctions = this.cronapi.myfunctions || {};
  
  /**
   * @type function
   * @name stopPropagation
   * @description Para a propagação do $event
   * @multilayer false
   * @param {ObjectType.ObjectType} event Param Description
   */
  this.cronapi.myfunctions.stopPropagation = function(/** @type {ObjectType.STRING} @description event: event */event) {
    event.stopPropagation();
  };

    /**
   * @type function
   * @name filter
   * @description Para a filter 
   * @multilayer false
   * @param {ObjectType.ObjectType} event Param Description
   * @returns {ObjectType.BOOLEAN}
   */
  this.cronapi.myfunctions.filterConversation = function(/** @type {ObjectType.STRING} @description conversation: conversation */conversation, /** @type {ObjectType.STRING} @description filter: filter */filter) {

    if(filter != "" && filter != undefined){
      let flag = conversation['contactName'].toLowerCase().startsWith(filter.toLowerCase());

      if(!flag){
        flag = conversation['userName'].toLowerCase().startsWith(filter.toLowerCase());
      }

      return flag;

    }
    
    return true;
  };


    /**
   * @type function
   * @name scroll
   * @description Elemento elem
   * @multilayer false
   * @param {ObjectType.STRING} elem Param Description
   */
  this.cronapi.myfunctions.scroll = function(/** @type {ObjectType.STRING} @description elem: elem */elem) {
    setTimeout( function() {
       $(elem).animate({ scrollTop: 200000000 }, "slow");
    }, 2000);
  };
  

}).bind(window)();