package lotto;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    @Test
    void checkLottoSize() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        int actual = lottoGenerator.getLotto().size();
        assertThat(actual).isEqualTo(6);
    }

    @Test
    void checkLottoNumberRange() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> lottoDigits =  lottoGenerator.getLotto();
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
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> lottoDigits =  lottoGenerator.getLotto();
        //중복제거를 위한 HashSet
        int actual = new HashSet<>(lottoDigits).size();
        assertThat(actual).isEqualTo(lottoDigits.size());
    }
}