package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoPurchaseAmountTest {

    @Test
    void create() {
        assertThatCode(() -> new LottoPurchaseAmount(1000))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("create 음수생성 실패")
    void createWithException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoPurchaseAmount(-2000));
    }

    @Test
    void numberOfTicket() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(6001);
        assertThat(lottoPurchaseAmount.numberOfTicket())
                .isEqualTo(6);
    }
}
