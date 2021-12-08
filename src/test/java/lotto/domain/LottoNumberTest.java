package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.util.LottoTestConstants.PARAMETRIZED_TEST_NAME;
import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {

    @ParameterizedTest(name = PARAMETRIZED_TEST_NAME)
    @ValueSource(ints = {1, 45})
    void of(int number) {
        assertThatCode(() -> LottoNumber.of(number))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest(name = PARAMETRIZED_TEST_NAME)
    @ValueSource(ints = {0, 46})
    @DisplayName("of 예외 케이스")
    void ofWithException(int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.of(number));
    }

    @Test
    void allLottoNumbers() {
        assertThat(LottoNumber.allLottoNumbers().size())
                .isEqualTo(45);

    }
}
