package com.xu.dashboard.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 学涂
 * @since 2022-03-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("Tmninfo")
public class Tmninfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private String id;

    private Integer regnum;

    @TableField("`describe`")
    private String describe;

    private String area;

    private String name;

    @TableField("IP")
    private String ip;

    private String username;

    private String password;


}
