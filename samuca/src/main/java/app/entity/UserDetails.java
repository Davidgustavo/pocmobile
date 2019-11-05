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
 * Classe que representa a tabela UserDetails
 * @generated
 */
@Entity
@XmlRootElement
@CronappSecurity(post = "Administrators", get = "Administrators", delete = "Administrators", put = "Administrators")
@JsonFilter("app.entity.UserDetails")
public class UserDetails implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

  private java.lang.String name;

  private java.lang.String login;

  private Boolean add;

  private String picture;

  public UserDetails(){
      
  }



	/**
 * @return the picture
 */
public String getPicture() {
	return picture;
}



/**
 * @param picture the picture to set
 */
public void setPicture(String picture) {
	this.picture = picture;
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
 * @return the name
 */
public java.lang.String getName() {
	return name;
}

/**
 * @param name the name to set
 */
public void setName(java.lang.String name) {
	this.name = name;
}

/**
 * @return the add
 */
public Boolean isAdd() {
	return add;
}

/**
 * @param add the add to set
 */
public void setAdd(Boolean add) {
	this.add = add;
}

public UserDetails(String id, String name, Boolean add){
      this.id = id;
      this.setName(name);
      this.setAdd(add);
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    UserDetails object = (UserDetails)obj;
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
