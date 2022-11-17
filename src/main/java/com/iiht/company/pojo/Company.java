package com.iiht.company.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    private String id;
    private String companyCode;
    private String companyName;
    private String companyCEO;
    private String companyTurnOver;
    private String website;
    private String stockExchange;
}
