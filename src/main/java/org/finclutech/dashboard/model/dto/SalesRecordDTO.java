package org.finclutech.dashboard.model.dto;

public class SalesRecordDTO {

    private Long id;
    private String businessCategory;
    private String status;
    private int amount;

    public SalesRecordDTO() {
    }

    public SalesRecordDTO(Long id, String businessCategory, String status, int amount) {
        this.id = id;
        this.businessCategory = businessCategory;
        this.status = status;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
