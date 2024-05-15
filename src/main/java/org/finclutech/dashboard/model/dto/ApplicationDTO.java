package org.finclutech.dashboard.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.finclutech.dashboard.configuration.CustomLocalDateTimeDeserializer;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("business_application_id")
    private Long businessApplicationId;
    @JsonProperty("sales_agent_first_name")
    private String salesAgentFirstName;
    @JsonProperty("sales_agent_last_name")
    private String salesAgentLastName;
    @JsonProperty("sales_agent_email")
    private String salesAgentEmail;
    @JsonProperty("account_type")
    private String accountType;

    @JsonProperty("created_at")
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime createdAt;
    @JsonProperty("application_status")
    private String applicationStatus;
    @JsonProperty("business_category")
    private String businessCategory;
    @JsonProperty("updated_at")
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}