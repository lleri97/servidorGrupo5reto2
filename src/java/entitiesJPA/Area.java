/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiesJPA;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author Andoni
 */
@Entity
@Table(name="area",schema="grupo5_database")
@XmlRootElement
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String name;
    
    @ManyToMany
    @JoinColumn(name="areas")
    private Collection<Department> departments;
    
    @ManyToMany
    @JoinTable(name="areas_documents")
    private Collection<Document> documents;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the departments
     */
    @XmlTransient
    public Collection<Department> getDepartments() {
        return departments;
    }
    /**
     * @param departments the departments to set
     */
    public void setDepartments(Collection<Department> departments) {
        this.departments = departments;
    }
    /**
     * @return the documents
     */
    @XmlTransient
    public Collection<Document> getDocuments() {
        return documents;
    }
    /**
     * @param documents the documents to set
     */
    public void setDocuments(Collection<Document> documents) {
        this.documents = documents;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }   
    
    @Override
    public String toString() {
        return "entitiesJPA.Area[ id=" + id + " ]";
    }
}