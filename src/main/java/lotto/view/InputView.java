package lotto.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);
    public Double getLottoPurchaseAmt() {
        System.out.println("구입금액을 입력해 주세요.");
        return Double.parseDouble(scanner.nextLine());
    }

    public String getWinnerNumber() {
        System.out.println("지난주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public int getBonusWinnerNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }
}
