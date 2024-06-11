package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
    public void resultPrize(Lotto lotto) {
        int matchCount = lotto.matchedCount(winningNumbers);
        boolean bonusMatch = lotto.contains(bonusNumber);
        determineResult(matchCount, bonusMatch);
    }

    private void determineResult(int matchCount, boolean bonusMatch) {
        String resultKey = matchCount + "," + bonusMatch;
        LottoResult lottoResult = Arrays.stream(
                LottoResult.values())
                    .filter(lo -> lo.getResultKey().equals(resultKey))
                    .collect(Collectors.toList()).get(0);
        lottoResult.plusCount();
    }

}
