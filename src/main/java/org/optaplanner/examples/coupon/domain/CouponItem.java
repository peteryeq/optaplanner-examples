package org.optaplanner.examples.coupon.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.examples.common.swingui.components.Labeled;

/**
 * CouponItem
 *
 * @see org.optaplanner.examples.nqueens.domain.Queen
 */
@PlanningEntity
public class CouponItem extends AbstractPersistable implements Labeled {

    /**
     * 优惠券金额
     */
    private int couponAmount;

    /**
     * 优惠券满减金额
     */
    private int couponFullReductionAmount;

    /**
     * planningVariable
     */
    private OrderItem orderItem;

    public CouponItem() {
    }

    public CouponItem(long id, int couponAmount, int couponFullReductionAmount) {
        super(id);
        this.couponAmount = couponAmount;
        this.couponFullReductionAmount = couponFullReductionAmount;
    }

    public int getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(int couponAmount) {
        this.couponAmount = couponAmount;
    }

    public int getCouponFullReductionAmount() {
        return couponFullReductionAmount;
    }

    public void setCouponFullReductionAmount(int couponFullReductionAmount) {
        this.couponFullReductionAmount = couponFullReductionAmount;
    }

    @PlanningVariable(nullable = true)
    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    @Override
    public String getLabel() {
        return "CouponItem " + id;
    }

    @Override
    public String toString() {
        return "CouponItem{" +
                "couponAmount=" + couponAmount +
                ", couponFullReductionAmount=" + couponFullReductionAmount +
                ", orderItem=" + orderItem +
                '}';
    }
}
