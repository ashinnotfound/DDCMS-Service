package com.webank.databrain.vo.request.dataschema;

import com.webank.databrain.vo.common.CommonRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateDataSchemaRequest extends CommonRequest {

    private Long schemaId;

    private String dataSchemaGid;

    private String did;

    @NotBlank(message = "dataSchemaName不能为空.")
    private String dataSchemaName;

    private String productName;

    private List<String> tagNameList;

    /**
     * 版本号
     */
    private Integer version;

    @NotBlank(message = "visible不能为空.")
    private Integer visible;

    @NotBlank(message = "dataSchemaDesc不能为空.")
    private String dataSchemaDesc;

    /**
     * 用途
     */
    private String dataSchemaUsage;

    /**
     * 价格
     */
    private Integer price;

    private Date createTime;


    private Long accessId;

    private Integer dataFormat;

    /**
     * 类型，HTTP-0，HTTPS-1，SFTP-2...
     */
    private Integer dataProtocol;

    /**
     * 内容格式
     */
    private String contentSchema;

    /**
     * 数据的查询条件定义
     */
    private String accessCondition;

    /**
     * 数据访问连接
     */
    private String uri;

    /**
     * 生效时间
     */
    private Date effectTime;

    /**
     * 失效时间
     */
    private Date expireTime;

}
