package iub.midterm_section4_2230369;

import java.time.LocalDate;

public class DataPackage {
    private String package_name;
    private Integer amount;
    private  String validity;
    private String availability;
    private Integer price;
    private LocalDate offer_ends;


    public DataPackage(String packageName, Integer amount, String validity, String availability,Integer price,LocalDate offerEnds) {
        this.package_name = packageName;
        this.amount = amount;
        this.validity = validity;
        this.availability = availability;
        this.price = price;
        this.offer_ends = offerEnds;
    }


    public String getPackage_name() {
        return package_name;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDate getOffer_ends() {
        return offer_ends;
    }

    public void setOffer_ends(LocalDate offer_ends) {
        this.offer_ends = offer_ends;
    }


    @Override
    public String toString() {
        return this.package_name + " " + this.amount + " " + this.availability + " " + this.validity + " " + this.price + " " + this.offer_ends;
    }
}
