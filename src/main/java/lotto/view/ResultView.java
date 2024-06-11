package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;

import java.util.List;

public class ResultView {

    public void printLottoCount(int autoCount, int manualCount) {
        System.out.println("수동으로 "+manualCount+"장, 자동으로 "+autoCount+"장 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumber());
        }
        System.out.println();
    }

    public void printStatics(double lottoPurchaseAmt) {
        int totalReward = 0;
        for (LottoResult lottoResult : LottoResult.values()) {
            if (lottoResult.getReward() != 0) {
                String matched = lottoResult.getMatched();
                int count = lottoResult.getCount();
                int reward = lottoResult.getReward();
                totalReward += reward * count;
                System.out.println(matched + "(" + reward + "원)- " + count +"개");
            }
        }
        double rateOfReturn = totalReward / lottoPurchaseAmt;
        rateOfReturn = Math.floor(rateOfReturn * 100.0) / 100.0;

        System.out.println("총 수익률은 "+ rateOfReturn + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
