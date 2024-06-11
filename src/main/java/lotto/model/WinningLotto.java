package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLotto {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final Lotto lotto;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber, Lotto lotto) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.lotto = lotto;
    }
    public void compareNumbers() {
        List<Integer> userNumbers = lotto.getLottoNumber();
        int matchCount = getMatchCount(userNumbers, winningNumbers);
        boolean bonusMatch = lotto.contains(bonusNumber);
        determineResult(matchCount, bonusMatch);
    }

    private int getMatchCount(List<Integer> userNumbers, List<Integer> winningNumbers) {
        return (int) userNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private void determineResult(int matchCount, boolean bonusMatch) {
        Map<String, LottoResult> resultMap = new HashMap<>();
        resultMap.put("6,false", LottoResult.FIRST_PRIZE);
        resultMap.put("5,true", LottoResult.SECOND_PRIZE);
        resultMap.put("5,false", LottoResult.THIRD_PRIZE);
        resultMap.put("4,false", LottoResult.FOURTH_PRIZE);
        resultMap.put("3,false", LottoResult.FIFTH_PRIZE);

        String key = matchCount + "," + bonusMatch;
        resultMap.getOrDefault(key, LottoResult.NO_PRIZE).plusCount();
    }

}
