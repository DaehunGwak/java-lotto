package lotto.domain;

import java.util.List;

public class WinningLottoTicket {

    private final LottoTicket winningLottoTicket;

    public WinningLottoTicket(int... lottoNumbers) {
        this(new LottoTicket(lottoNumbers));
    }

    public WinningLottoTicket(List<LottoNumber> lottoNumbers) {
        this(new LottoTicket(lottoNumbers));
    }

    public WinningLottoTicket(LottoTicket lottoTicket) {
        this.winningLottoTicket = lottoTicket;
    }
}
