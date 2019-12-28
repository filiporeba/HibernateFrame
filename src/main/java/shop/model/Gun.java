package shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gunId;
    private String gunProducent;
    private String gunName;
    private String gunCategory;
    private Integer gunCaliber;
    private Integer gunNumbOfMissiles;
    private String gunWeigth;
    private Integer gunPrice;

    public Gun(String gunProducent, String gunName, String gunCategory, Integer gunCaliber, Integer gunNumbOfMissiles, String gunWeigth, Integer gunPrice) {
        this.gunProducent = gunProducent;
        this.gunName = gunName;
        this.gunCategory = gunCategory;
        this.gunCaliber = gunCaliber;
        this.gunNumbOfMissiles = gunNumbOfMissiles;
        this.gunWeigth = gunWeigth;
        this.gunPrice = gunPrice;
    }

    public Gun() {
    }

    public Integer getGunId() {
        return gunId;
    }

    public void setGunId(Integer gunId) {
        this.gunId = gunId;
    }

    public String getGunProducent() {
        return gunProducent;
    }

    public void setGunProducent(String gunProducent) {
        this.gunProducent = gunProducent;
    }

    public String getGunName() {
        return gunName;
    }

    public void setGunName(String gunName) {
        this.gunName = gunName;
    }

    public String getGunCategory() {
        return gunCategory;
    }

    public void setGunCategory(String gunCategory) {
        this.gunCategory = gunCategory;
    }

    public Integer getGunCaliber() {
        return gunCaliber;
    }

    public void setGunCaliber(Integer gunCaliber) {
        this.gunCaliber = gunCaliber;
    }

    public Integer getGunNumbOfMissiles() {
        return gunNumbOfMissiles;
    }

    public void setGunNumbOfMissiles(Integer gunNumbOfMissiles) {
        this.gunNumbOfMissiles = gunNumbOfMissiles;
    }

    public String getGunWeigth() {
        return gunWeigth;
    }

    public void setGunWeigth(String gunWeigth) {
        this.gunWeigth = gunWeigth;
    }

    public Integer getGunPrice() {
        return gunPrice;
    }

    public void setGunPrice(Integer gunPrice) {
        this.gunPrice = gunPrice;
    }
}
