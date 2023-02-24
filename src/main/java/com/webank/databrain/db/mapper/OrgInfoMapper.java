package com.webank.databrain.db.mapper;

import com.webank.databrain.db.entity.OrgInfoDataObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.webank.databrain.model.common.IdName;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lt
 * @since 2023-02-22
 */
public interface OrgInfoMapper extends BaseMapper<OrgInfoDataObject> {
    List<IdName> selectHotEnterprises(int topN);

    int count();

    List<OrgInfoDataObject> listOrgs(int startOffset, int limitSize);
}
