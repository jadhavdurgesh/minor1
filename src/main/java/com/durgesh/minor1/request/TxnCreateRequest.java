package com.durgesh.minor1.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TxnCreateRequest {

    private String studentContact;

    private String bookNo;

    private Integer amount;
}
