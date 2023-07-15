package org.optaplanner.examples.coupon.domain;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardmediumsoft.HardMediumSoftScore;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.examples.common.domain.AbstractPersistable;

import java.util.List;

/**
 * CouponItem
 * @see org.optaplanner.examples.nqueens.domain.Queen
 */
@PlanningSolution
public class Orders extends AbstractPersistable {

    /**
     * 优惠券金额
     */
    private List<CouponItem> couponItemList;

    /**
     * 订单明细
     */
    private List<OrderItem> orderItemList;


    private HardMediumSoftScore hardMediumSoftScore;

    public Orders() {
    }

    public Orders(long id, List<CouponItem> couponItemList, List<OrderItem> orderItemList) {
        super(id);
        this.couponItemList = couponItemList;
        this.orderItemList = orderItemList;
    }

    @PlanningEntityCollectionProperty
    public List<CouponItem> getCouponItemList() {
        return couponItemList;
    }

    public void setCouponItemList(List<CouponItem> couponItemList) {
        this.couponItemList = couponItemList;
    }

    @ProblemFactCollectionProperty
    @ValueRangeProvider
    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    @PlanningScore
    public HardMediumSoftScore getHardMediumSoftScore() {
        return hardMediumSoftScore;
    }

    public void setHardMediumSoftScore(HardMediumSoftScore hardMediumSoftScore) {
        this.hardMediumSoftScore = hardMediumSoftScore;
    }
}
