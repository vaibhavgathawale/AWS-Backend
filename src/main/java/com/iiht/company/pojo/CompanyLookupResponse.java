package com.iiht.company.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyLookupResponse extends BaseResponse {
    private List<Company> companies;
    private Integer numberOfCompany;

    public CompanyLookupResponse(String message) {
        super(message);
    }
}
