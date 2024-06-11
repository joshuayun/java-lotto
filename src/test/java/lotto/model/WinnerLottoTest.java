package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerLottoTest {
    @Test
    void WinnerLottoNumberTest() {
        WinnerLotto winnerLotto = new WinnerLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Integer> actual = winnerLotto.getWinnerNumbers();
        assertThat(actual).containsExactly(1,2,3,4,5,6);
    }

}