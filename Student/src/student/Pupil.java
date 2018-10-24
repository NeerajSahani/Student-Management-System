/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "pupil", catalog = "student", schema = "")
@NamedQueries({
    @NamedQuery(name = "Pupil.findAll", query = "SELECT p FROM Pupil p")
    , @NamedQuery(name = "Pupil.findById", query = "SELECT p FROM Pupil p WHERE p.id = :id")
    , @NamedQuery(name = "Pupil.findByName", query = "SELECT p FROM Pupil p WHERE p.name = :name")
    , @NamedQuery(name = "Pupil.findByBranch", query = "SELECT p FROM Pupil p WHERE p.branch = :branch")
    , @NamedQuery(name = "Pupil.findByGender", query = "SELECT p FROM Pupil p WHERE p.gender = :gender")
    , @NamedQuery(name = "Pupil.findByAge", query = "SELECT p FROM Pupil p WHERE p.age = :age")
    , @NamedQuery(name = "Pupil.findByFee", query = "SELECT p FROM Pupil p WHERE p.fee = :fee")
    , @NamedQuery(name = "Pupil.findByDob", query = "SELECT p FROM Pupil p WHERE p.dob = :dob")
    , @NamedQuery(name = "Pupil.findByMaritalStatus", query = "SELECT p FROM Pupil p WHERE p.maritalStatus = :maritalStatus")
    , @NamedQuery(name = "Pupil.findByContact", query = "SELECT p FROM Pupil p WHERE p.contact = :contact")
    , @NamedQuery(name = "Pupil.findByAddress", query = "SELECT p FROM Pupil p WHERE p.address = :address")})
public class Pupil implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Branch")
    private String branch;
    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private Integer age;
    @Column(name = "Fee")
    private Integer fee;
    @Column(name = "DOB")
    private String dob;
    @Column(name = "Marital_Status")
    private String maritalStatus;
    @Column(name = "Contact")
    private String contact;
    @Column(name = "Address")
    private String address;
    @Lob
    @Column(name = "Image")
    private byte[] image;
    public Pupil() {
    }

    public Pupil(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        String oldBranch = this.branch;
        this.branch = branch;
        changeSupport.firePropertyChange("branch", oldBranch, branch);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        String oldGender = this.gender;
        this.gender = gender;
        changeSupport.firePropertyChange("gender", oldGender, gender);
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        Integer oldAge = this.age;
        this.age = age;
        changeSupport.firePropertyChange("age", oldAge, age);
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        Integer oldFee = this.fee;
        this.fee = fee;
        changeSupport.firePropertyChange("fee", oldFee, fee);
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        String oldDob = this.dob;
        this.dob = dob;
        changeSupport.firePropertyChange("dob", oldDob, dob);
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        String oldMaritalStatus = this.maritalStatus;
        this.maritalStatus = maritalStatus;
        changeSupport.firePropertyChange("maritalStatus", oldMaritalStatus, maritalStatus);
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        String oldContact = this.contact;
        this.contact = contact;
        changeSupport.firePropertyChange("contact", oldContact, contact);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        byte[] oldImage = this.image;
        this.image = image;
        changeSupport.firePropertyChange("image", oldImage, image);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pupil)) {
            return false;
        }
        Pupil other = (Pupil) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "student.Pupil[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
