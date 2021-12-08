package lotto;

import lotto.domain.LottoPurchaseAmount;
import lotto.domain.MyLottoTickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printPurchaseAmountInputGuide();
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(inputView.purchaseAmount());
        int numberOfTicket = lottoPurchaseAmount.numberOfTicket();
        outputView.printNumberOfTicket(numberOfTicket);

        MyLottoTickets myLottoTickets = MyLottoTickets.of(numberOfTicket);
        outputView.printMyLottoTickets(myLottoTickets);
    }
}
