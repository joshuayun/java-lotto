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

    // 당첨 번호와 사용자 번호를 비교하는 메서드
    public void compareNumbers() {
        int matchCount = 0;
        boolean bonusMatch = false;

        List<Integer> userNumbers = lotto.getNumber().getLottoNumber();
        List<Integer> winningNumbers = winnerLotto.getWinnerNumbers();
        int bonusNumber = winnerLotto.getBonusNumber();

        for (Integer number : userNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }

        if (userNumbers.contains(bonusNumber)) {
            bonusMatch = true;
        }

        LottoResult lottoResult = determineResult(matchCount, bonusMatch);
        lottoResult.plusCount();
    }

    // 맞춘 번호와 보너스 매치를 기반으로 결과를 결정하는 메서드 (케이스문 사용하지 않음)
    private LottoResult determineResult(int matchCount, boolean bonusMatch) {
        Map<String, LottoResult> resultMap = new HashMap<>();
        resultMap.put("6,false", LottoResult.FIRST_PRIZE);
        resultMap.put("5,true", LottoResult.SECOND_PRIZE);
        resultMap.put("5,false", LottoResult.THIRD_PRIZE);
        resultMap.put("4,false", LottoResult.FOURTH_PRIZE);
        resultMap.put("3,false", LottoResult.FIFTH_PRIZE);

        String key = matchCount + "," + bonusMatch;
        return resultMap.getOrDefault(key, LottoResult.NO_PRIZE);
    }

}
