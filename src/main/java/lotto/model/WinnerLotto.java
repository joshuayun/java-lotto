package lotto.model;

import java.util.List;

public class WinnerLotto {
    private final List<Integer> winnerNumbers;
    private final int bonusNumber;

    public WinnerLotto(List<Integer> winnerNumbers, int bonusNumber) {
        this.winnerNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }
    public List<Integer> getWinnerNumbers() {
        return winnerNumbers;
    }
    public int getBonusNumber() {
        return bonusNumber;
    }
}
