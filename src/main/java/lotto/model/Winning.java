package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Winning {

    private final WinnerLotto winnerLotto;

    private final Lotto lotto;

    public Winning(WinnerLotto winnerLotto, Lotto lotto) {
        this.winnerLotto = winnerLotto;
        this.lotto = lotto;
    }
    public void compareNumbers() {
        List<Integer> userNumbers = lotto.getLottoNumber();
        List<Integer> winningNumbers = winnerLotto.getWinnerNumbers();

        int bonusNumber = winnerLotto.getBonusNumber();
        int matchCount = getMatchCount(userNumbers, winningNumbers);
        boolean bonusMatch = userNumbers.contains(bonusNumber);
        determineResult(matchCount, bonusMatch);
    }

    private static int getMatchCount(List<Integer> userNumbers, List<Integer> winningNumbers) {
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
