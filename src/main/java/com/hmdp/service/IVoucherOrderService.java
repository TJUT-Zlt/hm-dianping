package com.hmdp.service;

import com.hmdp.dto.Result;
import com.hmdp.entity.VoucherOrder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author abel
 * @since 2021-12-22
 */
public interface IVoucherOrderService extends IService<VoucherOrder> {

    Result seckillVoucher1(Long voucherId);

    Result seckillVoucher2(Long voucherId);

    Result seckillVoucher3(Long voucherId);

    Result seckillVoucher4(Long voucherId);

    Result seckillVoucher5(Long voucherId);

    Result seckillVoucher_BQ(Long voucherId);

    Result seckillVoucher_MQ(Long voucherId);

    void createVoucherOrder_MQ(VoucherOrder voucherOrder);

    Result createVoucherOrder(Long voucherId);

    void createVoucherOrder_BQ(VoucherOrder voucherOrder);
}
