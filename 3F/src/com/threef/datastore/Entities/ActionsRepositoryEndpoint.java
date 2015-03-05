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

@Api(name = "actionsrepositoryendpoint", namespace = @ApiNamespace(ownerDomain = "threef.com", ownerName = "threef.com", packagePath="datastore.Entities"))
public class ActionsRepositoryEndpoint {

  /**
   * This method lists all the entities inserted in datastore.
   * It uses HTTP GET method and paging support.
   *
   * @return A CollectionResponse class containing the list of all entities
   * persisted and a cursor to the next page.
   */
  @SuppressWarnings({"unchecked", "unused"})
  @ApiMethod(name = "listActionsRepository")
  public CollectionResponse<ActionsRepository> listActionsRepository(
    @Nullable @Named("cursor") String cursorString,
    @Nullable @Named("limit") Integer limit) {

    PersistenceManager mgr = null;
    Cursor cursor = null;
    List<ActionsRepository> execute = null;

    try{
      mgr = getPersistenceManager();
      Query query = mgr.newQuery(ActionsRepository.class);
      if (cursorString != null && cursorString != "") {
        cursor = Cursor.fromWebSafeString(cursorString);
        HashMap<String, Object> extensionMap = new HashMap<String, Object>();
        extensionMap.put(JDOCursorHelper.CURSOR_EXTENSION, cursor);
        query.setExtensions(extensionMap);
      }

      if (limit != null) {
        query.setRange(0, limit);
      }

      execute = (List<ActionsRepository>) query.execute();
      cursor = JDOCursorHelper.getCursor(execute);
      if (cursor != null) cursorString = cursor.toWebSafeString();

      // Tight loop for fetching all entities from datastore and accomodate
      // for lazy fetch.
      for (ActionsRepository obj : execute);
    } finally {
      mgr.close();
    }

    return CollectionResponse.<ActionsRepository>builder()
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
  @ApiMethod(name = "getActionsRepository")
  public ActionsRepository getActionsRepository(@Named("id") Long id) {
    PersistenceManager mgr = getPersistenceManager();
    ActionsRepository actionsrepository  = null;
    try {
      actionsrepository = mgr.getObjectById(ActionsRepository.class, id);
    } finally {
      mgr.close();
    }
    return actionsrepository;
  }

  /**
   * This inserts a new entity into App Engine datastore. If the entity already
   * exists in the datastore, an exception is thrown.
   * It uses HTTP POST method.
   *
   * @param actionsrepository the entity to be inserted.
   * @return The inserted entity.
   */
  @ApiMethod(name = "insertActionsRepository")
  public ActionsRepository insertActionsRepository(ActionsRepository actionsrepository) {
    PersistenceManager mgr = getPersistenceManager();
    try {
      if(containsActionsRepository(actionsrepository)) {
        throw new EntityExistsException("Object already exists");
      }
      mgr.makePersistent(actionsrepository);
    } finally {
      mgr.close();
    }
    return actionsrepository;
  }

  /**
   * This method is used for updating an existing entity. If the entity does not
   * exist in the datastore, an exception is thrown.
   * It uses HTTP PUT method.
   *
   * @param actionsrepository the entity to be updated.
   * @return The updated entity.
   */
  @ApiMethod(name = "updateActionsRepository")
  public ActionsRepository updateActionsRepository(ActionsRepository actionsrepository) {
    PersistenceManager mgr = getPersistenceManager();
    try {
      if(!containsActionsRepository(actionsrepository)) {
        throw new EntityNotFoundException("Object does not exist");
      }
      mgr.makePersistent(actionsrepository);
    } finally {
      mgr.close();
    }
    return actionsrepository;
  }

  /**
   * This method removes the entity with primary key id.
   * It uses HTTP DELETE method.
   *
   * @param id the primary key of the entity to be deleted.
   */
  @ApiMethod(name = "removeActionsRepository")
  public void removeActionsRepository(@Named("id") Long id) {
    PersistenceManager mgr = getPersistenceManager();
    try {
      ActionsRepository actionsrepository = mgr.getObjectById(ActionsRepository.class, id);
      mgr.deletePersistent(actionsrepository);
    } finally {
      mgr.close();
    }
  }

  private boolean containsActionsRepository(ActionsRepository actionsrepository) {
    PersistenceManager mgr = getPersistenceManager();
    boolean contains = true;
    try {
      mgr.getObjectById(ActionsRepository.class, actionsrepository.getId());
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
