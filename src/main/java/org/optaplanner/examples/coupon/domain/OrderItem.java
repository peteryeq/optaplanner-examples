package org.optaplanner.examples.coupon.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.optaplanner.examples.cloudbalancing.domain.CloudComputer;
import org.optaplanner.examples.common.domain.AbstractPersistable;

/**
 * CouponItem
 *
 * @see org.optaplanner.examples.nqueens.domain.Queen
 */
@JsonIdentityInfo(scope = CloudComputer.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class OrderItem extends AbstractPersistable {

    /**
     * 订单项金额
     */
    private int orderItemAmount;

    public OrderItem() {
    }

    public OrderItem(long id, int orderItemAmount) {
        super(id);
        this.orderItemAmount = orderItemAmount;
    }

    public int getOrderItemAmount() {
        return orderItemAmount;
    }

    public void setOrderItemAmount(int orderItemAmount) {
        this.orderItemAmount = orderItemAmount;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemAmount=" + orderItemAmount +
                '}';
    }
}
