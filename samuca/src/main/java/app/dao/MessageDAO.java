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
@Repository("MessageDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface MessageDAO extends JpaRepository<Message, java.lang.String> {

  /**
   * Obtém a instância de Message utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Message entity WHERE entity.id = :id")
  public Message findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Message utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Message entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * Foreign Key group
   * @generated
   */
  @Query("SELECT entity FROM Message entity WHERE entity.group.id = :id")
  public Page<Message> findMessagesByGroup(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key user
   * @generated
   */
  @Query("SELECT entity FROM Message entity WHERE entity.user.id = :id")
  public Page<Message> findMessagesByUser(@Param(value="id") java.lang.String id, Pageable pageable);

}
