package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;

public enum LottoPrize {
    NOTHING(BigDecimal.valueOf(0), 0),
    THREE_SAME(BigDecimal.valueOf(5000), 3),
    FOUR_SAME(BigDecimal.valueOf(50000), 4),
    FIVE_SAME(BigDecimal.valueOf(1500000), 5),
    SIX_SAME(BigDecimal.valueOf(2000000000), 6),
    ;

    private final BigDecimal prizeMoney;
    private final long sameCount;

    LottoPrize(BigDecimal prizeMoney, int sameCount) {
        this.prizeMoney = prizeMoney;
        this.sameCount = sameCount;
    }

    public static LottoPrize of(LottoTicket myTicket, LottoTicket winnerTicket) {
        long count = myTicket.sameCount(winnerTicket);
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize.isSameCount(count))
                .findFirst()
                .orElse(NOTHING);
    }

    private boolean isSameCount(long sameCount) {
        return this.sameCount == sameCount;
    }

    public BigDecimal prizeMoney() {
        return prizeMoney;
    }

    public long sameCount() {
        return sameCount;
    }
}
