package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyLottoTickets {

    private final List<LottoTicket> lottoTickets;

    private MyLottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static MyLottoTickets of(int numberOfTicket) {
        List<LottoTicket> lottoTicketList = IntStream.range(0, numberOfTicket)
                .mapToObj(i -> LottoTicket.randomLottoNumbers())
                .collect(Collectors.toList());
        return new MyLottoTickets(lottoTicketList);
    }
}
