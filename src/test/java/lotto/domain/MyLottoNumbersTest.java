package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class MyLottoNumbersTest {

    @Test
    void of() {
        assertThatCode(() -> MyLottoNumbers.of(20))
                .doesNotThrowAnyException();
    }
}
