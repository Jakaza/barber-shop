package tut.ac.za.barbershop.entities;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Booking {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String contacts;
    private String time;
    private Date date;
    private String branch;
    private String style;
    private String status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @ManyToOne(fetch=FetchType.LAZY)
    private Customer customer;

    public Booking() {
    }

    public Booking(String name, String contacts, String time, Date date, String branch, String style, String status, Date creationDate, Customer customer) {
        this.name = name;
        this.contacts = contacts;
        this.time = time;
        this.date = date;
        this.branch = branch;
        this.style = style;
        this.status = status;
        this.creationDate = creationDate;
        this.customer = customer;
    }

    public Booking(Long id, String name, String contacts, String time, Date date, String branch, String style, String status, Date creationDate, Customer customer) {
        this.id = id;
        this.name = name;
        this.contacts = contacts;
        this.time = time;
        this.date = date;
        this.branch = branch;
        this.style = style;
        this.status = status;
        this.creationDate = creationDate;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
