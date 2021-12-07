package lotto.view;

import java.math.BigDecimal;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public BigDecimal purchaseAmount() {
        scanner.reset();
        return scanner.nextBigDecimal();
    }
}
