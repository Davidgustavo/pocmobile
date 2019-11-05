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
@Repository("GroupDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface GroupDAO extends JpaRepository<Group, java.lang.String> {

  /**
   * Obtém a instância de Group utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Group entity WHERE entity.id = :id")
  public Group findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Group utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Group entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Message entity WHERE entity.group.id = :id")
  public Page<Message> findMessage(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM UserGroup entity WHERE entity.group.id = :id")
  public Page<UserGroup> findUserGroup(@Param(value="id") java.lang.String id, Pageable pageable);
  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.user FROM Message entity WHERE entity.group.id = :id")
  public Page<User> listUser(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM Message entity WHERE entity.group.id = :instanceId AND entity.user.id = :relationId")
  public int deleteUser(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);
  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.user FROM UserGroup entity WHERE entity.group.id = :id")
  public Page<User> listUser_2(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM UserGroup entity WHERE entity.group.id = :instanceId AND entity.user.id = :relationId")
  public int deleteUser_2(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

  /**
   * Foreign Key user
   * @generated
   */
  @Query("SELECT entity FROM Group entity WHERE entity.user.id = :id")
  public Page<Group> findGroupsByUser(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key contact
   * @generated
   */
  @Query("SELECT entity FROM Group entity WHERE entity.contact.id = :id")
  public Page<Group> findGroupsByContact(@Param(value="id") java.lang.String id, Pageable pageable);

}
