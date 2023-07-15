package org.optaplanner.examples.coupon.app;

public class CouponCombination {

    public static void main(String[] args) {
        int[] couponAmount = {199, 194, 175, 120, 112, 144, 160, 105, 157, 178};
        int[] couponFullReductionAmount = {28, 26, 22, 8, 6, 3, 10, 15, 16, 28};

        int[] dp = new int[501]; // 初始化为0
        for (int i = 0; i < 10; i++) {
            for (int j = 500; j >= couponAmount[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-couponAmount[i]] + couponFullReductionAmount[i]);
            }
        }
        int maxCouponFullReductionAmount = dp[500];
        System.out.println("最大couponFullReductionAmount为：" + maxCouponFullReductionAmount);
    }
}
