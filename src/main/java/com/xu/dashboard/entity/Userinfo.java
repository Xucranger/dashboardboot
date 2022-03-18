package com.xu.dashboard.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("Userinfo")
public class Userinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String username;

    private String avatar;

    private String password;

    private String permission;


}
