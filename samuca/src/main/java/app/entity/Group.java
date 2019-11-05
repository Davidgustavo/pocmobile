package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela GROUP
 * @generated
 */
@Entity
@Table(name = "\"GROUP\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Group")
public class Group implements Serializable {

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
  @Column(name = "name", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String name;

  /**
  * @generated
  */
  @Column(name = "created_at", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String createdAt;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_user", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private User user;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_user_1", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private User contact;

  /**
   * Construtor
   * @generated
   */
  public Group(){
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
  public Group setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém name
   * return name
   * @generated
   */
  
  public java.lang.String getName(){
    return this.name;
  }

  /**
   * Define name
   * @param name name
   * @generated
   */
  public Group setName(java.lang.String name){
    this.name = name;
    return this;
  }

  /**
   * Obtém createdAt
   * return createdAt
   * @generated
   */
  
  public java.lang.String getCreatedAt(){
    return this.createdAt;
  }

  /**
   * Define createdAt
   * @param createdAt createdAt
   * @generated
   */
  public Group setCreatedAt(java.lang.String createdAt){
    this.createdAt = createdAt;
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
  public Group setUser(User user){
    this.user = user;
    return this;
  }

  /**
   * Obtém contact
   * return contact
   * @generated
   */
  
  public User getContact(){
    return this.contact;
  }

  /**
   * Define contact
   * @param contact contact
   * @generated
   */
  public Group setContact(User contact){
    this.contact = contact;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Group object = (Group)obj;
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
