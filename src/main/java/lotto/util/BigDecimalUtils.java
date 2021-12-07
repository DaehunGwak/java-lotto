package lotto.util;

import java.math.BigDecimal;

public class BigDecimalUtils {

    private static final int LESS_CHECKING_NUMBER = 0;

    private BigDecimalUtils() {}

    public static boolean negative(BigDecimal bigDecimal) {
        return bigDecimal.compareTo(BigDecimal.ZERO) < LESS_CHECKING_NUMBER;
    }
}
