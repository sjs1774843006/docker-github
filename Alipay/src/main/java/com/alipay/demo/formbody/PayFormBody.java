package com.alipay.demo.formbody;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * @author ：WenYuQi
 * @date ： 2019/10/9 9:42
 */
@Data
@ApiModel(value = "支付提交表单")
public class PayFormBody {

    /**
     * 商户订单号
     * */
    @ApiModelProperty(value = "商户订单号")
    @NotBlank(message = "商户订单号不能为空")
    private  String outTradeNo;

    /**
     * 订单名称
     * */
    @ApiModelProperty(value = "订单名称")
    @NotBlank(message = "订单名称不能为空")
    private  String subject;

    /**
     * 付款金额
     * */
    @ApiModelProperty(value = "付款金额")
    @NotBlank(message = "付款金额不能为空")
    private String totalAmount;

    /**
     * 商品描述
     * */
    @ApiModelProperty(value = "商品描述")
    private  String body;

}
