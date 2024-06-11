package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @Test
    void CheckWinningFirstPrize() {
        WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,4,5,6), 7);
        Lotto lotto = new Lotto(new LottoNumber(List.of(1,2,3,4,5,6)));

        winningLotto.resultPrize(lotto);
        int actual = LottoResult.FIFTH_PRIZE.getCount();
        assertThat(actual).isEqualTo(1);
    }

    @Test
    void CheckWinningSecondPrize() {
        WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,4,5,6), 7);
        Lotto lotto = new Lotto(new LottoNumber(List.of(1,2,3,4,5,7)));

        winningLotto.resultPrize(lotto);
        int actual = LottoResult.SECOND_PRIZE.getCount();
        assertThat(actual).isEqualTo(1);
    }

    @Test
    void CheckWinningThirdPrize() {
        WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,4,5,6), 7);
        Lotto lotto = new Lotto(new LottoNumber(List.of(1,2,3,4,5,8)));

        winningLotto.resultPrize(lotto);
        int actual = LottoResult.THIRD_PRIZE.getCount();
        assertThat(actual).isEqualTo(1);
    }

    @Test
    void CheckWinningFourthPrize() {
        WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,4,5,6), 7);
        Lotto lotto = new Lotto(new LottoNumber(List.of(1,2,3,4,8,9)));

        winningLotto.resultPrize(lotto);
        int actual = LottoResult.FOURTH_PRIZE.getCount();
        assertThat(actual).isEqualTo(1);
    }

    @Test
    void CheckWinningFifthPrize() {
        WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,4,5,6), 7);
        Lotto lotto = new Lotto(new LottoNumber(List.of(1,2,3,8,9,10)));

        winningLotto.resultPrize(lotto);
        int actual = LottoResult.FIFTH_PRIZE.getCount();
        assertThat(actual).isEqualTo(1);
    }

}