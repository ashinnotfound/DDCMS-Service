package com.webank.databrain.model.dataschema;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateDataSchemaRequest {

    private Long providerId;

    private Long productId;

    private Integer version;

    private Integer visible;

    private String description;

    private String usage;

    private Integer price;

    private Integer type;

    private Integer protocol;

    private String schema;

    private String condition;

    private String uri;

    private LocalDateTime effectTime;

    private LocalDateTime expireTime;

}
