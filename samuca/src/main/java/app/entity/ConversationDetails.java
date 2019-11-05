package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;
import lombok.Getter;
import lombok.Setter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * Classe que representa a tabela ConversationDetails
 * @generated
 */
@Entity
@XmlRootElement
@CronappSecurity(post = "Administrators", get = "Administrators", delete = "Administrators", put = "Administrators")
@JsonFilter("app.entity.ConversationDetails")
public class ConversationDetails implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  private java.lang.String id;

  private java.lang.String userId;
 
  private java.lang.String userName;

  private java.lang.String userLogin;

  private java.lang.String contactId;

  private java.lang.String contactName;

  private java.lang.String contactLogin;

  private java.lang.String message;

  private java.lang.String userImage;

  private java.lang.String contactImage;


  public ConversationDetails(){
      
  }


    /**
 * @return the contactImage
 */
public java.lang.String getContactImage() {
	return contactImage;
}


/**
 * @param contactImage the contactImage to set
 */
public void setContactImage(java.lang.String contactImage) {
	this.contactImage = contactImage;
}


	/**
 * @return the userImage
 */
public java.lang.String getUserImage() {
	return userImage;
}


/**
 * @param userImage the userImage to set
 */
public void setUserImage(java.lang.String userImage) {
	this.userImage = userImage;
}


	/**
 * @return the message
 */
public java.lang.String getMessage() {
	return message;
}


/**
 * @param message the message to set
 */
public void setMessage(java.lang.String message) {
	this.message = message;
}


	/**
 * @return the contactLogin
 */
public java.lang.String getContactLogin() {
	return contactLogin;
}


/**
 * @param contactLogin the contactLogin to set
 */
public void setContactLogin(java.lang.String contactLogin) {
	this.contactLogin = contactLogin;
}


	/**
 * @return the contactName
 */
public java.lang.String getContactName() {
	return contactName;
}


/**
 * @param contactName the contactName to set
 */
public void setContactName(java.lang.String contactName) {
	this.contactName = contactName;
}


	/**
 * @return the contactId
 */
public java.lang.String getContactId() {
	return contactId;
}


/**
 * @param contactId the contactId to set
 */
public void setContactId(java.lang.String contactId) {
	this.contactId = contactId;
}


	/**
 * @return the userLogin
 */
public java.lang.String getUserLogin() {
	return userLogin;
}


/**
 * @param userLogin the userLogin to set
 */
public void setUserLogin(java.lang.String userLogin) {
	this.userLogin = userLogin;
}


	/**
 * @return the userName
 */
public java.lang.String getUserName() {
	return userName;
}


/**
 * @param userName the userName to set
 */
public void setUserName(java.lang.String userName) {
	this.userName = userName;
}


	/**
 * @return the userId
 */
public java.lang.String getUserId() {
	return userId;
}


/**
 * @param userId the userId to set
 */
public void setUserId(java.lang.String userId) {
	this.userId = userId;
}


	/**
  * @return the id
  */
  public java.lang.String getId() {
    return id;
  }

  /**
  * @param name the name to set
  */
  public void setId(java.lang.String id) {
    this.id = id;
  }



  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    ConversationDetails object = (ConversationDetails)obj;
    if (id != null ? !id.equals(object.id) : object.id != null) return false;
    return true;
  }

  /**
   * @generated
   */
  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

}
