/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emerskitchen;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
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
@Table(name = "stock", catalog = "emers_db", schema = "")
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s")
    , @NamedQuery(name = "Stock.findByStockCode", query = "SELECT s FROM Stock s WHERE s.stockCode = :stockCode")
    , @NamedQuery(name = "Stock.findByStockTakingDate", query = "SELECT s FROM Stock s WHERE s.stockTakingDate = :stockTakingDate")
    , @NamedQuery(name = "Stock.findByQuantityInStock", query = "SELECT s FROM Stock s WHERE s.quantityInStock = :quantityInStock")
    , @NamedQuery(name = "Stock.findByProdId", query = "SELECT s FROM Stock s WHERE s.prodId = :prodId")})
public class Stock implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stock_code")
    private Integer stockCode;
    @Column(name = "stock_taking_date")
    @Temporal(TemporalType.DATE)
    private Date stockTakingDate;
    @Basic(optional = false)
    @Column(name = "quantity_in_stock")
    private String quantityInStock;
    @Basic(optional = false)
    @Column(name = "prod_id")
    private int prodId;

    public Stock() {
    }

    public Stock(Integer stockCode) {
        this.stockCode = stockCode;
    }

    public Stock(Integer stockCode, String quantityInStock, int prodId) {
        this.stockCode = stockCode;
        this.quantityInStock = quantityInStock;
        this.prodId = prodId;
    }

    public Integer getStockCode() {
        return stockCode;
    }

    public void setStockCode(Integer stockCode) {
        Integer oldStockCode = this.stockCode;
        this.stockCode = stockCode;
        changeSupport.firePropertyChange("stockCode", oldStockCode, stockCode);
    }

    public Date getStockTakingDate() {
        return stockTakingDate;
    }

    public void setStockTakingDate(Date stockTakingDate) {
        Date oldStockTakingDate = this.stockTakingDate;
        this.stockTakingDate = stockTakingDate;
        changeSupport.firePropertyChange("stockTakingDate", oldStockTakingDate, stockTakingDate);
    }

    public String getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(String quantityInStock) {
        String oldQuantityInStock = this.quantityInStock;
        this.quantityInStock = quantityInStock;
        changeSupport.firePropertyChange("quantityInStock", oldQuantityInStock, quantityInStock);
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        int oldProdId = this.prodId;
        this.prodId = prodId;
        changeSupport.firePropertyChange("prodId", oldProdId, prodId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stockCode != null ? stockCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.stockCode == null && other.stockCode != null) || (this.stockCode != null && !this.stockCode.equals(other.stockCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emerskitchen.Stock[ stockCode=" + stockCode + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
