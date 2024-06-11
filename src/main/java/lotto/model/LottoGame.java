package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;

    private final int count;

    public LottoGame(Double lottoPurchaseAmt) {
        count = (int) (lottoPurchaseAmt / LOTTO_PRICE);
    }

    public List<Lotto> generateLotto() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(new LottoNumber());
            lottos.add(lotto);
        }
        return lottos;
    }

    public int getCount() {
        return count;
    }


}
