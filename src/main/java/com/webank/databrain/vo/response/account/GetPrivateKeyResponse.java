package com.webank.databrain.vo.response.account;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetPrivateKeyResponse {
    private String privateKey;
}
