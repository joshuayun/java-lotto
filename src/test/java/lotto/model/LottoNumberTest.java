package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {
    @Test
    void checkLottoSize() {
        LottoNumber lottoNumber = new LottoNumber();
        int actual = lottoNumber.getNumbers().size();
        assertThat(actual).isEqualTo(6);
    }

    @Test
    void checkLottoNumberRange() {
        LottoNumber lottoNumber = new LottoNumber();
        List<Integer> lottoDigits =  lottoNumber.getNumbers();
        boolean actual = checkRangeNumber(lottoDigits);
        assertThat(actual).isTrue();
    }

    private static boolean checkRangeNumber(List<Integer> lottoDigits) {
        for (int number : lottoDigits) {
            if (number >= 1 && number <= 45) {
               return true;
            }
        }
        return false;
    }

    @Test
    void checkLottoDuplicateNumber() {
        LottoNumber lottoNumber = new LottoNumber();
        List<Integer> lottoDigits =  lottoNumber.getNumbers();
        int actual = new HashSet<>(lottoDigits).size();
        assertThat(actual).isEqualTo(lottoDigits.size());
    }
}