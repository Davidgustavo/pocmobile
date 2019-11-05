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
 * Classe que representa a tabela MessageDetails
 * @generated
 */
@Entity
@XmlRootElement
@CronappSecurity(post = "Administrators", get = "Administrators", delete = "Administrators", put = "Administrators")
@JsonFilter("app.entity.MessageDetails")
public class MessageDetails implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

  private java.lang.String userName;

  private java.lang.String userId;

  private java.lang.String message;

  private java.lang.String login;

  private java.lang.String userImage;

  public MessageDetails(){
      
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
 * @return the login
 */
public java.lang.String getLogin() {
	return login;
}

/**
 * @param login the login to set
 */
public void setLogin(java.lang.String login) {
	this.login = login;
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
    MessageDetails object = (MessageDetails)obj;
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
