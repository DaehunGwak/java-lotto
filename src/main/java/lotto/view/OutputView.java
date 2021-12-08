package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.MyLottoTickets;

import java.util.stream.Collectors;

public class OutputView {

    private static final String LOTTO_TICKET_PREFIX = "[";
    private static final String LOTTO_TICKET_POSTFIX = "]";

    public void printPurchaseAmountInputGuide() {
        System.out.println("구입 금액을 입력해주세요.");
    }

    public void printNumberOfTicket(int numberOfTicket) {
        System.out.println(numberOfTicket + "개를 구매했습니다.");
    }

    public void printMyLottoTickets(MyLottoTickets myLottoTickets) {
        myLottoTickets.lottoTickets()
                .forEach(this::printLottoTicket);
        System.out.println();
    }

    private void printLottoTicket(LottoTicket lottoTicket) {
        String lottoNumbers = lottoTicket.lottoNumbers()
                .stream()
                .map(LottoNumber::lottoNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(LOTTO_TICKET_PREFIX + lottoNumbers + LOTTO_TICKET_POSTFIX);
    }
}
