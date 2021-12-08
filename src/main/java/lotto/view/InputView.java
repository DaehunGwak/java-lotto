package lotto.view;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private static final String LOTTO_NUMBERS_DELIMITER = ", ";

    private final Scanner scanner = new Scanner(System.in);

    public BigDecimal purchaseAmount() {
        return new BigDecimal(scanner.nextLine());
    }

    public int[] lottoNumbers() {
        String[] numbers = scanner.nextLine()
                .split(LOTTO_NUMBERS_DELIMITER);
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
