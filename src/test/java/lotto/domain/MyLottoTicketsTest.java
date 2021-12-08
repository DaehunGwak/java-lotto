package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

class MyLottoTicketsTest {

    @Test
    void of() {
        assertThatCode(() -> MyLottoTickets.of(20))
                .doesNotThrowAnyException();
    }
}
