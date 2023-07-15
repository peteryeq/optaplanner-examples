package org.optaplanner.examples.coupon.score;

import org.optaplanner.core.api.score.buildin.hardmediumsoft.HardMediumSoftScore;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;
import org.optaplanner.examples.coupon.domain.CouponItem;
import org.optaplanner.examples.coupon.domain.OrderItem;
import org.optaplanner.examples.pas.domain.BedDesignation;

import java.util.function.Function;

import static org.optaplanner.core.api.score.stream.ConstraintCollectors.sum;

/**
 * CouponOptConstraintProvider
 *
 * @see org.optaplanner.examples.cloudbalancing.score.CloudBalancingConstraintProvider
 */
public class CouponOptConstraintProvider implements ConstraintProvider {


    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[]{
                requiredCouponAmtTotal(constraintFactory),
                couponPenalize(constraintFactory)
//                couponAmtMax(constraintFactory)
        };
    }

    // Hard constraints
    Constraint requiredCouponAmtTotal(ConstraintFactory constraintFactory) {
        return constraintFactory.forEach(CouponItem.class)
                .groupBy(CouponItem::getOrderItem, sum(CouponItem::getCouponAmount))
                .filter((orderItem, couponAmout) -> couponAmout > orderItem.getOrderItemAmount())
                .penalize(HardMediumSoftScore.ONE_HARD,
                        (orderItem, couponAmout) -> couponAmout - orderItem.getOrderItemAmount())
                .asConstraint("requiredCouponAmtTotal");
    }

    // Soft constraints
//    Constraint couponAmtMax(ConstraintFactory constraintFactory) {
//        return constraintFactory.forEach(CouponItem.class)
//                .groupBy(CouponItem::getOrderItem, sum(CouponItem::getCouponFullReductionAmount))
//                .filter((orderItem, couponFullReductionAmount) -> orderItem.getOrderItemAmount() - couponFullReductionAmount > 0)
//                .penalize(HardSoftScore.ONE_SOFT, ((orderItem, integer) -> orderItem.getOrderItemAmount() - integer))
//                .asConstraint("couponAmtMax");
//    }

    Constraint couponAmtMax(ConstraintFactory constraintFactory) {
        return constraintFactory.forEach(CouponItem.class)
                .groupBy(CouponItem::getOrderItem, sum(CouponItem::getCouponFullReductionAmount))
                .reward(HardMediumSoftScore.ONE_SOFT, ((orderItem, integer) -> integer))
                .asConstraint("couponAmtMax");
    }

    //Medium
//    public Constraint assignEveryPatientToABedConstraint(ConstraintFactory constraintFactory) {
//        return constraintFactory.forEachIncludingNullVars(BedDesignation.class)
//                .filter(bd -> bd.getBed() == null)
//                .penalize(HardMediumSoftScore.ONE_MEDIUM, BedDesignation::getAdmissionPartNightCount)
//                .asConstraint("assignEveryPatientToABed");
//    }


    Constraint couponPenalize(ConstraintFactory constraintFactory) {
        return constraintFactory.forEachIncludingNullVars(CouponItem.class)
                .filter(cp -> cp.getOrderItem() == null)
                .penalize(HardMediumSoftScore.ONE_SOFT, CouponItem::getCouponFullReductionAmount)
                .asConstraint("couponPenalize");
    }


}
