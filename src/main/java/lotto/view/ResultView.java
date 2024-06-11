package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;

import java.util.List;

public class ResultView {

    public void printLottoCount(int number) {
        System.out.println(number + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumber().getLottoNumber());
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
                System.out.println(matched + ":" + count);
            }
        }
        double rateOfReturn = totalReward / lottoPurchaseAmt;
        rateOfReturn = Math.floor(rateOfReturn * 100.0) / 100.0;

        System.out.println("총 수익률:"+ rateOfReturn);

    }
}
