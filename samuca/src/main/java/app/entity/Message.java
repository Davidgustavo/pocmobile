package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela MESSAGE
 * @generated
 */
@Entity
@Table(name = "\"MESSAGE\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Message")
public class Message implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "id", nullable = false, insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

  /**
  * @generated
  */
  @Column(name = "message", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String message;

  /**
  * @generated
  */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "send_date", nullable = true, unique = false, insertable=true, updatable=true, columnDefinition = "TIMESTAMP")
  
  private java.util.Date sendDate = Calendar.getInstance().getTime();

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_group", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private Group group;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_user", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private User user;

  /**
   * Construtor
   * @generated
   */
  public Message(){
  }


  /**
   * Obtém id
   * return id
   * @generated
   */
  
  public java.lang.String getId(){
    return this.id;
  }

  /**
   * Define id
   * @param id id
   * @generated
   */
  public Message setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém message
   * return message
   * @generated
   */
  
  public java.lang.String getMessage(){
    return this.message;
  }

  /**
   * Define message
   * @param message message
   * @generated
   */
  public Message setMessage(java.lang.String message){
    this.message = message;
    return this;
  }

  /**
   * Obtém sendDate
   * return sendDate
   * @generated
   */
  
  public java.util.Date getSendDate(){
    return this.sendDate;
  }

  /**
   * Define sendDate
   * @param sendDate sendDate
   * @generated
   */
  public Message setSendDate(java.util.Date sendDate){
    this.sendDate = sendDate;
    return this;
  }

  /**
   * Obtém group
   * return group
   * @generated
   */
  
  public Group getGroup(){
    return this.group;
  }

  /**
   * Define group
   * @param group group
   * @generated
   */
  public Message setGroup(Group group){
    this.group = group;
    return this;
  }

  /**
   * Obtém user
   * return user
   * @generated
   */
  
  public User getUser(){
    return this.user;
  }

  /**
   * Define user
   * @param user user
   * @generated
   */
  public Message setUser(User user){
    this.user = user;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Message object = (Message)obj;
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
