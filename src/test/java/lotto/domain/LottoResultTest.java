package lotto.domain;

import lotto.domain.util.LottoTestUtils;
import lotto.util.LottoConstants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @ParameterizedTest(name = LottoTestUtils.PARAMETRIZED_TEST_NAME)
    @CsvSource(value = {
            "SIX_SAME,1/2/3/4/5/6",
            "THREE_SAME,4/5/6/7/8/9",
            "NOTHING,7/8/9/10/11/12"
    })
    void lottoPrizeCount(LottoPrize lottoPrize, String numbers) {
        LottoPrice lottoPrice = new LottoPrice(3000);
        List<LottoNumber> lottoNumbers = LottoTestUtils.lottoNumbers(numbers);
        List<LottoTicket> lottoTickets = Collections.singletonList(
                LottoTicket.customLottoTicket(lottoNumbers));

        MyLottoTickets myLottoTickets = new MyLottoTickets(lottoPrice, lottoTickets);
        LottoTicket winnerLottoTicket = LottoTicket.customLottoTicket(1, 2, 3, 4, 5, 6);

        LottoResult lottoResult = new LottoResult(myLottoTickets, winnerLottoTicket);
        lottoResult.countPrize();

        assertThat(lottoResult.lottoPrizeCount(lottoPrize))
                .isEqualTo(1);
    }

    @Test
    void earningRate() {
        BigDecimal purchaseAmount = BigDecimal.valueOf(3000);
        BigDecimal earningAmount = Stream.of(LottoPrize.SIX_SAME, LottoPrize.FIVE_SAME, LottoPrize.NOTHING)
                .map(LottoPrize::prizeMoney)
                .reduce(BigDecimal::add)
                .get();

        LottoPrice lottoPrice = new LottoPrice(purchaseAmount);
        List<LottoTicket> lottoTickets = Arrays.asList(
                LottoTicket.customLottoTicket(1, 2, 3, 4, 5, 6), // SIX_SAME
                LottoTicket.customLottoTicket(2, 3, 4, 5, 6, 7), // FIVE_SAME
                LottoTicket.customLottoTicket(7, 8, 9, 10, 11, 12)); // NOTHING
        MyLottoTickets myLottoTickets = new MyLottoTickets(lottoPrice, lottoTickets);
        LottoTicket winnerLottoTicket = LottoTicket.customLottoTicket(1, 2, 3, 4, 5, 6);

        LottoResult lottoResult = new LottoResult(myLottoTickets, winnerLottoTicket);
        lottoResult.countPrize();

        BigDecimal expectedEarningRate = earningAmount.divide(
                lottoPrice.realPurchaseAmount(),
                LottoConstants.EARNING_RATE_SCALE,
                RoundingMode.HALF_EVEN);

        assertThat(lottoResult.earningRate())
                .isEqualTo(expectedEarningRate);
    }
}
