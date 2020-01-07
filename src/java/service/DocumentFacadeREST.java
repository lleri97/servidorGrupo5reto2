/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entitiesJPA.Document;
import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.GetCollectionException;
import exceptions.UpdateException;
import interfaces.EJBDocumentInterface;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ruben
 */
@Path("document")
public class DocumentFacadeREST {

    @EJB(beanName="EJBDocument")
    private EJBDocumentInterface ejb;

    @POST
    @Consumes({MediaType.APPLICATION_XML})
    public void create(Document document) {
        try {
            ejb.createNewDocument(document);

        } catch (CreateException ex) {
            Logger.getLogger(CompanyFacadeREST.class.getName()).severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML})
    public void edit(@PathParam("id") Integer id, Document document) {
        try {
            ejb.updateDocument(document);
        } catch (UpdateException ex) {
            Logger.getLogger(CompanyFacadeREST.class.getName()).severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        try {
            ejb.deleteDocument(id);
        } catch (DeleteException ex) {
            Logger.getLogger(CompanyFacadeREST.class.getName()).severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Collection<Document> findAll() {
        Collection<Document> documents = null;
        try {
            documents = ejb.getDocumentList();
        } catch (GetCollectionException ex) {
            Logger.getLogger(CompanyFacadeREST.class.getName()).severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
        return documents;
    }
}