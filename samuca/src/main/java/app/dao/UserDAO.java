package app.dao;

import app.entity.*;
import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.*;
import org.springframework.transaction.annotation.*; 


/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * Os métodos de create, edit, delete e outros estão abstraídos no JpaRepository
 * 
 * @see org.springframework.data.jpa.repository.JpaRepository
 * 
 * @generated
 */
@Repository("UserDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface UserDAO extends JpaRepository<User, java.lang.String> {

  /**
   * Obtém a instância de User utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM User entity WHERE entity.id = :id")
  public User findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de User utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM User entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Group entity WHERE entity.user.id = :id")
  public Page<Group> findGroup(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Group entity WHERE entity.contact.id = :id")
  public Page<Group> findGroup_2(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Message entity WHERE entity.user.id = :id")
  public Page<Message> findMessage(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Role entity WHERE entity.user.id = :id")
  public Page<Role> findRole(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM UserGroup entity WHERE entity.user.id = :id")
  public Page<UserGroup> findUserGroup(@Param(value="id") java.lang.String id, Pageable pageable);
  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.group FROM Message entity WHERE entity.user.id = :id")
  public Page<Group> listGroup_3(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM Message entity WHERE entity.user.id = :instanceId AND entity.group.id = :relationId")
  public int deleteGroup_3(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);
  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.group FROM UserGroup entity WHERE entity.user.id = :id")
  public Page<Group> listGroup_4(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM UserGroup entity WHERE entity.user.id = :instanceId AND entity.group.id = :relationId")
  public int deleteGroup_4(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

}
