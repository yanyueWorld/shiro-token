package com.example.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Table: role
 */
@Data
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Table:     role
     * Column:    id
     * Nullable:  false
     */
    private Integer id;
    /**
     * 角色id
     * <p>
     * Table:     role
     * Column:    role_id
     * Nullable:  false
     */
    private String roleId;
    /**
     * 角色名称
     * <p>
     * Table:     role
     * Column:    name
     * Nullable:  false
     */
    private String name;
    /**
     * 角色描述
     * <p>
     * Table:     role
     * Column:    description
     * Nullable:  true
     */
    private String description;
    /**
     * 状态：1有效；2删除
     * <p>
     * Table:     role
     * Column:    status
     * Nullable:  false
     */
    private Integer status;
    /**
     * 创建时间
     * <p>
     * Table:     role
     * Column:    create_time
     * Nullable:  true
     */
    private Date createTime;
    /**
     * 更新时间
     * <p>
     * Table:     role
     * Column:    update_time
     * Nullable:  true
     */
    private Date updateTime;
}