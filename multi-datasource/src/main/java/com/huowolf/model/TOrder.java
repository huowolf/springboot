package com.huowolf.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @创建人：王小伟
 * @创建时间： 2019/10/9
 * @描述：
 */
@TableName(value = "t_order_0000")
@Data
public class TOrder {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Long userId;

    private Long orderId;

    private String userName;
}
