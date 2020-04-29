/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emerskitchen;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author florm
 */
@Entity
@Table(name = "suppliers", catalog = "emers_db", schema = "")
@NamedQueries({
    @NamedQuery(name = "Suppliers.findAll", query = "SELECT s FROM Suppliers s")
    , @NamedQuery(name = "Suppliers.findBySupId", query = "SELECT s FROM Suppliers s WHERE s.supId = :supId")
    , @NamedQuery(name = "Suppliers.findBySname", query = "SELECT s FROM Suppliers s WHERE s.sname = :sname")
    , @NamedQuery(name = "Suppliers.findByEmail", query = "SELECT s FROM Suppliers s WHERE s.email = :email")
    , @NamedQuery(name = "Suppliers.findByPhone", query = "SELECT s FROM Suppliers s WHERE s.phone = :phone")
    , @NamedQuery(name = "Suppliers.findBySite", query = "SELECT s FROM Suppliers s WHERE s.site = :site")
    , @NamedQuery(name = "Suppliers.findByContactName", query = "SELECT s FROM Suppliers s WHERE s.contactName = :contactName")
    , @NamedQuery(name = "Suppliers.findByCategory", query = "SELECT s FROM Suppliers s WHERE s.category = :category")
    , @NamedQuery(name = "Suppliers.findByOtherSupplierDetails", query = "SELECT s FROM Suppliers s WHERE s.otherSupplierDetails = :otherSupplierDetails")})
public class Suppliers implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sup_id")
    private Integer supId;
    @Basic(optional = false)
    @Column(name = "sname")
    private String sname;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @Column(name = "site")
    private String site;
    @Basic(optional = false)
    @Column(name = "contact_name")
    private String contactName;
    @Basic(optional = false)
    @Column(name = "category")
    private String category;
    @Column(name = "other_supplier_details")
    private String otherSupplierDetails;

    public Suppliers() {
    }

    public Suppliers(Integer supId) {
        this.supId = supId;
    }

    public Suppliers(Integer supId, String sname, String email, String phone, String contactName, String category) {
        this.supId = supId;
        this.sname = sname;
        this.email = email;
        this.phone = phone;
        this.contactName = contactName;
        this.category = category;
    }

    public Integer getSupId() {
        return supId;
    }

    public void setSupId(Integer supId) {
        Integer oldSupId = this.supId;
        this.supId = supId;
        changeSupport.firePropertyChange("supId", oldSupId, supId);
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        String oldSname = this.sname;
        this.sname = sname;
        changeSupport.firePropertyChange("sname", oldSname, sname);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        String oldPhone = this.phone;
        this.phone = phone;
        changeSupport.firePropertyChange("phone", oldPhone, phone);
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        String oldSite = this.site;
        this.site = site;
        changeSupport.firePropertyChange("site", oldSite, site);
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        String oldContactName = this.contactName;
        this.contactName = contactName;
        changeSupport.firePropertyChange("contactName", oldContactName, contactName);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        String oldCategory = this.category;
        this.category = category;
        changeSupport.firePropertyChange("category", oldCategory, category);
    }

    public String getOtherSupplierDetails() {
        return otherSupplierDetails;
    }

    public void setOtherSupplierDetails(String otherSupplierDetails) {
        String oldOtherSupplierDetails = this.otherSupplierDetails;
        this.otherSupplierDetails = otherSupplierDetails;
        changeSupport.firePropertyChange("otherSupplierDetails", oldOtherSupplierDetails, otherSupplierDetails);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supId != null ? supId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suppliers)) {
            return false;
        }
        Suppliers other = (Suppliers) object;
        if ((this.supId == null && other.supId != null) || (this.supId != null && !this.supId.equals(other.supId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emerskitchen.Suppliers[ supId=" + supId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
