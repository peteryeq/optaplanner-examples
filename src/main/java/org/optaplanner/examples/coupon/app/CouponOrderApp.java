package org.optaplanner.examples.coupon.app;

import cn.hutool.core.util.RandomUtil;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.config.solver.SolverConfig;
import org.optaplanner.core.config.solver.termination.TerminationConfig;
import org.optaplanner.examples.coupon.domain.CouponItem;
import org.optaplanner.examples.coupon.domain.OrderItem;
import org.optaplanner.examples.coupon.domain.Orders;
import org.optaplanner.examples.coupon.score.CouponOptConstraintProvider;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CouponOrderApp {

    public static void main(String[] args) {

        TerminationConfig terminationConfig = new TerminationConfig();
//        terminationConfig.withBestScoreLimit("0hard/400soft");
        terminationConfig.setUnimprovedSpentLimit(Duration.ofSeconds(3));

        SolverFactory<Orders> solverFactory = SolverFactory.create(new SolverConfig()
                .withSolutionClass(Orders.class)
                .withEntityClasses(CouponItem.class)
                .withConstraintProviderClass(CouponOptConstraintProvider.class)
                .withTerminationConfig(terminationConfig));
        Solver<Orders> solver = solverFactory.buildSolver();

        //
        Orders orders = generateOrders();
        printOrders(orders);
        Orders solve = solver.solve(orders);
        printOrders(solve);
    }

    static void printOrders(Orders orders) {
        System.out.println("优惠券明细：");
        orders.getCouponItemList().forEach(System.out::println);
        System.out.println("订单明细：");
        orders.getOrderItemList().forEach(System.out::println);
        orders.getCouponItemList().stream().filter(a -> a.getOrderItem() != null)
                .map(CouponItem::getCouponAmount).reduce(Integer::sum).ifPresent(System.out::println);
        orders.getCouponItemList().stream().filter(a -> a.getOrderItem() != null)
                .map(CouponItem::getCouponFullReductionAmount).reduce(Integer::sum).ifPresent(System.out::println);
    }


    public static Orders generateOrders() {
        List<CouponItem> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            CouponItem couponItem = new CouponItem(
                    Long.valueOf(i),
                    RandomUtil.randomInt(100, 200),
                    RandomUtil.randomInt(3, 30)
            );
            list.add(couponItem);
        }
        OrderItem orderItem = new OrderItem(1, 500);
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(orderItem);
        Orders orders = new Orders(1L, list, orderItems);
        return orders;
    }
}
