package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private static final int LOTTO_NUMBERS_START_INDEX = 0;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(int... lottoNumbers) {
        this(Arrays.stream(lottoNumbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("numbers 사이즈가 " + LOTTO_NUMBER_SIZE + "이 아닙니다");
        }
        List<LottoNumber> newLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(newLottoNumbers);
        this.lottoNumbers = newLottoNumbers;
    }

    public static LottoTicket randomLottoNumbers() {
        List<LottoNumber> allLottoNumbers = new ArrayList<>(LottoNumber.allLottoNumbers());
        Collections.shuffle(allLottoNumbers);
        List<LottoNumber> sixLottoNumbers = allLottoNumbers.subList(LOTTO_NUMBERS_START_INDEX, LOTTO_NUMBER_SIZE);
        return new LottoTicket(sixLottoNumbers);
    }
}
