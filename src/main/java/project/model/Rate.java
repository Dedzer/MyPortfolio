package project.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "rate")
public class Rate {
    @Id
    public int rateID;
    @Column
    public int rate;
    @Column
    public String description;

    public int getRateID() {
        return rateID;
    }

    public void setRateID(int rateID) {
        this.rateID = rateID;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Rate() {
    }

    public Rate(int rateID, int rate, String description) {
        this.rateID = rateID;
        this.rate = rate;
        this.description = description;
    }
}
