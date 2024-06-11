package lotto.model;

import java.util.List;

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
        addLottoResultCount(matchCount, bonusMatch);
    }

    private void addLottoResultCount(int matchCount, boolean bonusMatch) {
        String resultKey = matchCount + "," + bonusMatch;
        for (LottoResult lottoResult : LottoResult.values()) {
            if (lottoResult.getResultKey().equals(resultKey)) {
                lottoResult.addCount();
            }
        }
    }

}
