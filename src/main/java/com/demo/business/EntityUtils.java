package com.demo.business;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.demo.utils.GenerateID;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * 通用实体
 * @author Hullson
 * @since 2023-06-17
 * @description 包括id createBy createDate updateBy updateTime
 */
@Data
@NoArgsConstructor
public class EntityUtils {

    private static final long serialVersionUID = 1L;

    private static final String DEL_NORMAL = "0";
    private static final String DEL_REMOVE = "1";

    private String id;
    private String createBy;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    private String updateBy;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;
    private String delFlag;
    private String remark;

    private List<OrderItem> orders;

    public EntityUtils(String id) {
        this();
        this.id = id;
    }

    public void preInsert() {
        if (StringUtils.isEmpty(this.id)) {
            setId(GenerateID.generateUUID());
        }
        this.setCreateDate(new Date());
        this.setUpdateDate(new Date());
        this.delFlag = DEL_NORMAL;
    }

    public void preUpdate() {
        this.setUpdateDate(new Date());
    }
}
