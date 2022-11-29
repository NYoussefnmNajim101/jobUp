package com.example.jobup.domain;

import java.io.Serializable;

public class JobOfferDomain implements Serializable {

    private int offerId;
    private String offerTitle;
    private String offerEmail;
    private String offerPhone;

    public JobOfferDomain() {

    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    private  String offerDescription;


    public JobOfferDomain(String offerTitle, String offerEmail, String offerPhone, String offerDescription) {
        this.offerTitle = offerTitle;
        this.offerEmail = offerEmail;
        this.offerPhone = offerPhone;
        this.offerDescription = offerDescription;
    }

    public String getOfferTitle() {
        return offerTitle;
    }

    public void setOfferTitle(String offerTitle) {
        this.offerTitle = offerTitle;
    }

    public String getOfferEmail() {
        return offerEmail;
    }

    public void setOfferEmail(String offerEmail) {
        this.offerEmail = offerEmail;
    }

    public String getOfferPhone() {
        return offerPhone;
    }

    public void setOfferPhone(String offerPhone) {
        this.offerPhone = offerPhone;
    }

    public String getOfferDescription() {
        return offerDescription;
    }

    public void setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
    }
}
