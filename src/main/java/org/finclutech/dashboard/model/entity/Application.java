package org.finclutech.dashboard.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "applications")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Application {
    @Id
    @Column(name = "business_application_id")
    private Long businessApplicationId;

    @Column(name = "sales_agent_first_name")
    private String salesAgentFirstName;

    @Column(name = "sales_agent_last_name")
    private String salesAgentLastName;

    @Column(name = "sales_agent_email")
    private String salesAgentEmail;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "application_status")
    private String applicationStatus;

    @Column(name = "business_category")
    private String businessCategory;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Long getBusinessApplicationId() {
        return businessApplicationId;
    }

    public void setBusinessApplicationId(Long businessApplicationId) {
        this.businessApplicationId = businessApplicationId;
    }

    public String getSalesAgentFirstName() {
        return salesAgentFirstName;
    }

    public void setSalesAgentFirstName(String salesAgentFirstName) {
        this.salesAgentFirstName = salesAgentFirstName;
    }

    public String getSalesAgentLastName() {
        return salesAgentLastName;
    }

    public void setSalesAgentLastName(String salesAgentLastName) {
        this.salesAgentLastName = salesAgentLastName;
    }

    public String getSalesAgentEmail() {
        return salesAgentEmail;
    }

    public void setSalesAgentEmail(String salesAgentEmail) {
        this.salesAgentEmail = salesAgentEmail;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
