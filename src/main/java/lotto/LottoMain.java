package lotto;

import lotto.domain.LottoPurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printPurchaseAmountInputGuide();
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(inputView.purchaseAmount());
    }
}
