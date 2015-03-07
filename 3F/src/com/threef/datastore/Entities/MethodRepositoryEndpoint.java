package com.threef.datastore.Entities;

import com.threef.datastore.Entities.PMF;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JDOCursorHelper;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

@Api(name = "methodrepositoryendpoint", namespace = @ApiNamespace(ownerDomain = "threef.com", ownerName = "threef.com", packagePath="datastore.Entities"))
public class MethodRepositoryEndpoint {

  /**
   * This method lists all the entities inserted in datastore.
   * It uses HTTP GET method and paging support.
   *
   * @return A CollectionResponse class containing the list of all entities
   * persisted and a cursor to the next page.
   */
  @SuppressWarnings({"unchecked", "unused"})
  @ApiMethod(name = "listMethodRepository")
  public CollectionResponse<MethodRepository> listMethodRepository(
    @Nullable @Named("cursor") String cursorString,
    @Nullable @Named("limit") Integer limit) {

    PersistenceManager mgr = null;
    Cursor cursor = null;
    List<MethodRepository> execute = null;

    try{
      mgr = getPersistenceManager();
      Query query = mgr.newQuery(MethodRepository.class);
      if (cursorString != null && cursorString != "") {
        cursor = Cursor.fromWebSafeString(cursorString);
        HashMap<String, Object> extensionMap = new HashMap<String, Object>();
        extensionMap.put(JDOCursorHelper.CURSOR_EXTENSION, cursor);
        query.setExtensions(extensionMap);
      }

      if (limit != null) {
        query.setRange(0, limit);
      }

      execute = (List<MethodRepository>) query.execute();
      cursor = JDOCursorHelper.getCursor(execute);
      if (cursor != null) cursorString = cursor.toWebSafeString();

      // Tight loop for fetching all entities from datastore and accomodate
      // for lazy fetch.
      for (MethodRepository obj : execute);
    } finally {
      mgr.close();
    }

    return CollectionResponse.<MethodRepository>builder()
      .setItems(execute)
      .setNextPageToken(cursorString)
      .build();
  }

  /**
   * This method gets the entity having primary key id. It uses HTTP GET method.
   *
   * @param id the primary key of the java bean.
   * @return The entity with primary key id.
   */
  @ApiMethod(name = "getMethodRepository")
  public MethodRepository getMethodRepository(@Named("id") Long id) {
    PersistenceManager mgr = getPersistenceManager();
    MethodRepository methodrepository  = null;
    try {
      methodrepository = mgr.getObjectById(MethodRepository.class, id);
    } finally {
      mgr.close();
    }
    return methodrepository;
  }

  /**
   * This inserts a new entity into App Engine datastore. If the entity already
   * exists in the datastore, an exception is thrown.
   * It uses HTTP POST method.
   *
   * @param methodrepository the entity to be inserted.
   * @return The inserted entity.
   */
  @ApiMethod(name = "insertMethodRepository")
  public MethodRepository insertMethodRepository(MethodRepository methodrepository) {
    PersistenceManager mgr = getPersistenceManager();
    try {
    	if(methodrepository.getId()!=null)
      if(containsMethodRepository(methodrepository)) {
        throw new EntityExistsException("Object already exists");
      }
      mgr.makePersistent(methodrepository);
    } finally {
      mgr.close();
    }
    return methodrepository;
  }

  /**
   * This method is used for updating an existing entity. If the entity does not
   * exist in the datastore, an exception is thrown.
   * It uses HTTP PUT method.
   *
   * @param methodrepository the entity to be updated.
   * @return The updated entity.
   */
  @ApiMethod(name = "updateMethodRepository")
  public MethodRepository updateMethodRepository(MethodRepository methodrepository) {
    PersistenceManager mgr = getPersistenceManager();
    try {
      if(!containsMethodRepository(methodrepository)) {
        throw new EntityNotFoundException("Object does not exist");
      }
      mgr.makePersistent(methodrepository);
    } finally {
      mgr.close();
    }
    return methodrepository;
  }

  /**
   * This method removes the entity with primary key id.
   * It uses HTTP DELETE method.
   *
   * @param id the primary key of the entity to be deleted.
   */
  @ApiMethod(name = "removeMethodRepository")
  public void removeMethodRepository(@Named("id") Long id) {
    PersistenceManager mgr = getPersistenceManager();
    try {
      MethodRepository methodrepository = mgr.getObjectById(MethodRepository.class, id);
      mgr.deletePersistent(methodrepository);
    } finally {
      mgr.close();
    }
  }

  private boolean containsMethodRepository(MethodRepository methodrepository) {
    PersistenceManager mgr = getPersistenceManager();
    boolean contains = true;
    try {
      mgr.getObjectById(MethodRepository.class, methodrepository.getId());
    } catch (javax.jdo.JDOObjectNotFoundException ex) {
      contains = false;
    } finally {
      mgr.close();
    }
    return contains;
  }

  private static PersistenceManager getPersistenceManager() {
    return PMF.get().getPersistenceManager();
  }

}
