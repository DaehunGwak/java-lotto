package lotto.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static lotto.util.LottoTestConstants.PARAMETRIZED_TEST_NAME;
import static org.assertj.core.api.Assertions.assertThat;

class BigDecimalUtilsTest {

    @ParameterizedTest(name = PARAMETRIZED_TEST_NAME)
    @CsvSource(value = {"0,false", "-1,true"})
    void negative(int value, boolean expected) {
        BigDecimal bigDecimal = BigDecimal.valueOf(value);
        assertThat(BigDecimalUtils.negative(bigDecimal))
                .isEqualTo(expected);
    }
}
