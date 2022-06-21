package com.nttdata.bc19.msproductpasive.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PasiveProduct extends BaseModel {
    private String name;
    private double transactionCommission;
    private double minimumOpeningAmount;
    private double minimumVIPAmount;
    private int numLimitMovements;
    private Boolean allowBusinessClient;
    private Boolean allowPersonClient;
    private Boolean mustHaveCreditCardVIP;
}
