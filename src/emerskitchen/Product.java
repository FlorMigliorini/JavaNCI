/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emerskitchen;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author florm
 */
@Entity
@Table(name = "product", catalog = "emers_db", schema = "")
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
    , @NamedQuery(name = "Product.findByProdCode", query = "SELECT p FROM Product p WHERE p.prodCode = :prodCode")
    , @NamedQuery(name = "Product.findByProdName", query = "SELECT p FROM Product p WHERE p.prodName = :prodName")
    , @NamedQuery(name = "Product.findByProdPriceGross", query = "SELECT p FROM Product p WHERE p.prodPriceGross = :prodPriceGross")
    , @NamedQuery(name = "Product.findByProdPriceShop", query = "SELECT p FROM Product p WHERE p.prodPriceShop = :prodPriceShop")
    , @NamedQuery(name = "Product.findByDeliveryDate", query = "SELECT p FROM Product p WHERE p.deliveryDate = :deliveryDate")
    , @NamedQuery(name = "Product.findByProdQtity", query = "SELECT p FROM Product p WHERE p.prodQtity = :prodQtity")
    , @NamedQuery(name = "Product.findBySupId", query = "SELECT p FROM Product p WHERE p.supId = :supId")})
public class Product implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prod_code")
    private Integer prodCode;
    @Basic(optional = false)
    @Column(name = "prod_name")
    private String prodName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "prod_price_gross")
    private BigDecimal prodPriceGross;
    @Basic(optional = false)
    @Column(name = "prod_price_shop")
    private BigDecimal prodPriceShop;
    @Column(name = "delivery_date")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;
    @Basic(optional = false)
    @Column(name = "prod_qtity")
    private String prodQtity;
    @Basic(optional = false)
    @Column(name = "sup_id")
    private int supId;

    public Product() {
    }

    public Product(Integer prodCode) {
        this.prodCode = prodCode;
    }

    public Product(Integer prodCode, String prodName, BigDecimal prodPriceGross, BigDecimal prodPriceShop, String prodQtity, int supId) {
        this.prodCode = prodCode;
        this.prodName = prodName;
        this.prodPriceGross = prodPriceGross;
        this.prodPriceShop = prodPriceShop;
        this.prodQtity = prodQtity;
        this.supId = supId;
    }

    Product(int aInt, String string, int aInt0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Product(int aInt, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getProdCode() {
        return prodCode;
    }

    public void setProdCode(Integer prodCode) {
        Integer oldProdCode = this.prodCode;
        this.prodCode = prodCode;
        changeSupport.firePropertyChange("prodCode", oldProdCode, prodCode);
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        String oldProdName = this.prodName;
        this.prodName = prodName;
        changeSupport.firePropertyChange("prodName", oldProdName, prodName);
    }

    public BigDecimal getProdPriceGross() {
        return prodPriceGross;
    }

    public void setProdPriceGross(BigDecimal prodPriceGross) {
        BigDecimal oldProdPriceGross = this.prodPriceGross;
        this.prodPriceGross = prodPriceGross;
        changeSupport.firePropertyChange("prodPriceGross", oldProdPriceGross, prodPriceGross);
    }

    public BigDecimal getProdPriceShop() {
        return prodPriceShop;
    }

    public void setProdPriceShop(BigDecimal prodPriceShop) {
        BigDecimal oldProdPriceShop = this.prodPriceShop;
        this.prodPriceShop = prodPriceShop;
        changeSupport.firePropertyChange("prodPriceShop", oldProdPriceShop, prodPriceShop);
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        Date oldDeliveryDate = this.deliveryDate;
        this.deliveryDate = deliveryDate;
        changeSupport.firePropertyChange("deliveryDate", oldDeliveryDate, deliveryDate);
    }

    public String getProdQtity() {
        return prodQtity;
    }

    public void setProdQtity(String prodQtity) {
        String oldProdQtity = this.prodQtity;
        this.prodQtity = prodQtity;
        changeSupport.firePropertyChange("prodQtity", oldProdQtity, prodQtity);
    }

    public int getSupId() {
        return supId;
    }

    public void setSupId(int supId) {
        int oldSupId = this.supId;
        this.supId = supId;
        changeSupport.firePropertyChange("supId", oldSupId, supId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodCode != null ? prodCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.prodCode == null && other.prodCode != null) || (this.prodCode != null && !this.prodCode.equals(other.prodCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emerskitchen.Product[ prodCode=" + prodCode + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
