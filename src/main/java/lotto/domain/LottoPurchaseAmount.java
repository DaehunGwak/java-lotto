package lotto.domain;

import lotto.util.BigDecimalUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LottoPurchaseAmount {

    private static final BigDecimal PRICE_PER_LOTTO = BigDecimal.valueOf(1_000);
    private static final int NUMBER_OF_TICKET_SCALE = 0;

    private final BigDecimal purchaseAmount;

    public LottoPurchaseAmount(int purchaseAmount) {
        this(BigDecimal.valueOf(purchaseAmount));
    }

    public LottoPurchaseAmount(BigDecimal purchaseAmount) {
        if (BigDecimalUtils.negative(purchaseAmount)) {
            throw new IllegalArgumentException("음수는 생성할 수 없습니다");
        }
        this.purchaseAmount = purchaseAmount;
    }

    public int numberOfTicket() {
        return purchaseAmount.divide(PRICE_PER_LOTTO, NUMBER_OF_TICKET_SCALE, RoundingMode.FLOOR)
                .intValue();
    }
}
