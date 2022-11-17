package com.iiht.company.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCompanyResponse extends BaseResponse {
    private String id;

    public AddCompanyResponse(String message, String id) {
        super(message);
        this.id = id;
    }
}
