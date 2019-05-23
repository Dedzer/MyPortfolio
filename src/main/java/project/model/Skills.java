package project.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "skills")
public class Skills {
    @Id
    private int id;
    @Column
    public String name;
    @Column
    public String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rateID")
    public Rate rate;

    public Skills(int id, String name, String description, Rate rate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rate = rate;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Skills() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
