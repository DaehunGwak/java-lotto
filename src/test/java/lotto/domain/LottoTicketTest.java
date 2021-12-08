package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static lotto.util.LottoTestConstants.PARAMETRIZED_TEST_NAME;
import static org.assertj.core.api.Assertions.*;

class LottoTicketTest {

    @Test
    void create() {
        assertThatCode(() -> new LottoTicket(1, 2, 3, 5, 9, 45))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest(name = PARAMETRIZED_TEST_NAME)
    @CsvSource(value = {"0,1,2,3,4,5", "1,2,3,4,5,46"})
    @DisplayName("create 실패 케이스")
    void createWithException(int n1, int n2, int n3, int n4, int n5, int n6) {
        int[] numbers = {n1, n2, n3, n4, n5, n6};
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(numbers));
    }

    @Test
    void randomLottoNumbers() {
        assertThatCode(LottoTicket::randomLottoNumbers)
                .doesNotThrowAnyException();
    }
}
