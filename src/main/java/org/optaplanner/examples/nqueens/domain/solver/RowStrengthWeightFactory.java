package org.optaplanner.examples.nqueens.domain.solver;

import java.util.Comparator;

import org.optaplanner.core.impl.heuristic.selector.common.decorator.SelectionSorterWeightFactory;
import org.optaplanner.examples.nqueens.domain.NQueens;
import org.optaplanner.examples.nqueens.domain.Row;

public class RowStrengthWeightFactory implements SelectionSorterWeightFactory<NQueens, Row> {

    /**
     * 这段代码是一个静态方法，用于计算给定 n * n 的矩阵中某个元素到中心元素的距离。其中，n 表示矩阵的大小，columnIndex 表示某个元素的列索引。
     *
     * 具体来说，代码中的 calculateDistanceFromMiddle 方法首先计算出矩阵中心的列索引，即 middle = n / 2。然后，通过取 columnIndex 和 middle 的差值的绝对值来计算给定元素到中心元素的距离，即 distanceFromMiddle = Math.abs(columnIndex - middle)。
     *
     * 在计算距离时，还需要考虑矩阵大小 n 的奇偶性。如果 n 是偶数且 columnIndex 小于 middle，则 distanceFromMiddle 需要再减去 1，以便计算出实际的距离。这是因为矩阵中心在两个元素中间时，我们需要将距离近的元素视为中心元素。
     *
     * 最后，该方法返回计算出的距离值 distanceFromMiddle。
     *
     * 总之，calculateDistanceFromMiddle 方法是一个用于计算矩阵中某个元素到中心元素距离的通用方法，可以在各种场景下使用。
     * @param n
     * @param columnIndex
     * @return
     */
    private static int calculateDistanceFromMiddle(int n, int columnIndex) {
        int middle = n / 2;
        int distanceFromMiddle = Math.abs(columnIndex - middle);
        if ((n % 2 == 0) && (columnIndex < middle)) {
            distanceFromMiddle--;
        }
        return distanceFromMiddle;
    }

    @Override
    public RowStrengthWeight createSorterWeight(NQueens nQueens, Row row) {
        int distanceFromMiddle = calculateDistanceFromMiddle(nQueens.getN(), row.getIndex());
        return new RowStrengthWeight(row, distanceFromMiddle);
    }

    /**
     * 在一些特殊情况下，可能会发现约靠近中间的皇后更容易与其他皇后冲突，但这并不是 N 皇后问题本身的特性。
     */
    public static class RowStrengthWeight implements Comparable<RowStrengthWeight> {

        // The stronger rows are on the side, so they have a higher distance to the middle
        // 较强的行在侧面，因此它们到中间的距离较远
        // distanceFromMiddle 升序，若distanceFromMiddle相同然后rowIndex升序
        private static final Comparator<RowStrengthWeight> COMPARATOR = Comparator
                .comparingInt((RowStrengthWeight weight) -> weight.distanceFromMiddle)
                .thenComparingInt(weight -> weight.row.getIndex());

        private final Row row;
        private final int distanceFromMiddle;

        public RowStrengthWeight(Row row, int distanceFromMiddle) {
            this.row = row;
            this.distanceFromMiddle = distanceFromMiddle;
        }

        @Override
        public int compareTo(RowStrengthWeight other) {
            return COMPARATOR.compare(this, other);
        }
    }
}
