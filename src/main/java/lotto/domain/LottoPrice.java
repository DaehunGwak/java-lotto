package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 역할: 로또 지불액을 입력받아 티켓 수 추출
 */
public class LottoPrice {

    private static final BigDecimal PRICE_PER_LOTTO = BigDecimal.valueOf(1000);
    private static final int BIG_DECIMAL_SCALE_FOR_INT = 0;

    private final BigDecimal purchaseAmount;

    public LottoPrice(int purchaseAmount) {
        this(BigDecimal.valueOf(purchaseAmount));
    }

    public LottoPrice(BigDecimal purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public BigDecimal realPurchaseAmount() {
        return BigDecimal.valueOf(numberOfTicket())
                .multiply(PRICE_PER_LOTTO);
    }

    public int numberOfTicket() {
        return purchaseAmount.divide(PRICE_PER_LOTTO, BIG_DECIMAL_SCALE_FOR_INT, RoundingMode.FLOOR)
                .intValue();
    }
}
