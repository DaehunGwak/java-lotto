package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyLottoNumbers {

    private final List<LottoNumbers> lottoNumbersList;

    private MyLottoNumbers(List<LottoNumbers> lottoNumbersList) {
        this.lottoNumbersList = lottoNumbersList;
    }

    public static MyLottoNumbers of(int numberOfTicket) {
        List<LottoNumbers> lottoNumbersList = IntStream.range(0, numberOfTicket)
                .mapToObj(i -> LottoNumbers.randomLottoNumbers())
                .collect(Collectors.toList());
        return new MyLottoNumbers(lottoNumbersList);
    }
}
