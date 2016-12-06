package com.batchsi.dataloader.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "t_parameters")
public class Parameter {

    @Id
    @GeneratedValue
    @Column(name = "parameter_id")
    private long id;

    @Column(name = "parameter_name", length = 128, nullable = false)
    private String name;

    @Column(name = "parameter_value", length = 1024, nullable = false)
    private String value;

    @Column(name = "parameter_description", length = 1024, nullable = false)
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
