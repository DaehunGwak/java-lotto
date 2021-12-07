package lotto.domain;

import lotto.util.LottoConstants;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private final MyLottoTickets myLottoTickets;
    private final LottoTicket winnerLottoTicket;
    private final Map<LottoPrize, Long> prizeCount = new EnumMap<>(LottoPrize.class);

    public LottoResult(MyLottoTickets myLottoTickets, LottoTicket winnerLottoTicket) {
        this.myLottoTickets = myLottoTickets;
        this.winnerLottoTicket = winnerLottoTicket;
    }

    public void countPrize() {
        List<LottoPrize> mappedLottoPrizes = myLottoTickets.lottoTickets()
                .stream()
                .map(lottoTicket -> LottoPrize.of(lottoTicket, winnerLottoTicket))
                .collect(Collectors.toList());
        for (LottoPrize keyLottoPrize: LottoPrize.values()) {
            putPrizeCount(mappedLottoPrizes, keyLottoPrize);
        }
    }

    private void putPrizeCount(List<LottoPrize> mappedLottoPrizes, LottoPrize keyLottoPrize) {
        long count = mappedLottoPrizes.stream()
                .filter(prize -> prize == keyLottoPrize)
                .count();
        prizeCount.put(keyLottoPrize, count);
    }

    public long lottoPrizeCount(LottoPrize lottoPrize) {
        return prizeCount.get(lottoPrize);
    }

    public BigDecimal earningRate() {
        BigDecimal totalPrizeAmount = prizeCount.entrySet()
                .stream()
                .map(this::eachPrizeAmount)
                .reduce(BigDecimal::add)
                .orElseThrow(() -> new ArithmeticException("earningRate 추출 계산 중 오류가 있습니다"));
        return totalPrizeAmount.divide(
                myLottoTickets.totalTicketPurchasePrice(),
                LottoConstants.EARNING_RATE_SCALE,
                RoundingMode.HALF_EVEN);
    }

    private BigDecimal eachPrizeAmount(Map.Entry<LottoPrize, Long> lottoPrizeLongEntry) {
        return lottoPrizeLongEntry.getKey()
                .prizeMoney()
                .multiply(BigDecimal.valueOf(lottoPrizeLongEntry.getValue())) ;
    }
}
