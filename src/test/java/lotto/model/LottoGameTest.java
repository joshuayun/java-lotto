package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @Test
    void autoLottoCount() {
        LottoGame lottoGame = new LottoGame(14000.0, 3) ;
        int actual = lottoGame.getAutoCount();
        assertThat(actual).isEqualTo(11);
    }
    @Test
    void gernerateAutoLottoCount() {
        LottoGame lottoGame = new LottoGame(14000.0, 3) ;
        List<Lotto> manualLotto = new ArrayList<>();
        manualLotto.add(new Lotto(new LottoNumber(List.of(1,2,3,4,5,6))));
        manualLotto.add(new Lotto(new LottoNumber(List.of(1,3,4,5,6,45))));

        List<Lotto> lottos = lottoGame.generateLotto(manualLotto);
        List<Integer> actual = lottos.get(0).getLottoNumber();
        assertThat(actual).containsExactly(1,2,3,4,5,6);
    }


}