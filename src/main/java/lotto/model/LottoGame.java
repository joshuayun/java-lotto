package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;

    private final int autoCount;

    public LottoGame(Double lottoPurchaseAmt, int manualCount) {
        autoCount = (int) (lottoPurchaseAmt / LOTTO_PRICE) - manualCount;
    }

    public List<Lotto> generateLotto(List<Lotto> manualLotto) {
        List<Lotto> lottos = new ArrayList<>(manualLotto);
        generateAutoLottos(lottos);
        return lottos;
    }

    private void generateAutoLottos(List<Lotto> lottos) {
        for (int i = 0; i < autoCount; i++) {
            Lotto lotto = new Lotto(new LottoNumber());
            lottos.add(lotto);
        }
    }

    public int getAutoCount() {
        return autoCount;
    }
}
