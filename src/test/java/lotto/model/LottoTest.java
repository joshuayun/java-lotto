package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class LottoTest {

    @MethodSource("listProvider")
    @ParameterizedTest
    void lottoNumber(List<Integer> numbers){
        Lotto lotto = new Lotto(new LottoNumber(numbers));
        List<Integer> actual = lotto.getLottoNumber();
        assertThat(actual).isEqualTo(numbers);
    }

    public static Stream<Arguments> listProvider() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(20, 21, 23, 41, 42, 43)),
                Arguments.of(List.of(5, 4, 6, 13, 15, 24))
        );
    }
    @MethodSource("containsNumberProvider")
    @ParameterizedTest
    void containsNumber(List<Integer> numbers, int checkNumber){
        Lotto lotto = new Lotto(new LottoNumber(numbers));
        boolean actual = lotto.contains(checkNumber);
        assertThat(actual).isTrue();
    }

    public static Stream<Arguments> containsNumberProvider() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 2),
                Arguments.of(List.of(20, 21, 23, 41, 42, 43), 21),
                Arguments.of(List.of(5 ,4, 6, 13, 15, 24), 15)
        );
    }


    @MethodSource("matchedCountProvider")
    @ParameterizedTest
    void matchedCount(List<Integer> lottoNumbers){
        Lotto lotto = new Lotto(new LottoNumber(lottoNumbers));
        int actual = lotto.matchedCount(List.of(1, 2, 3, 4, 7, 8));
        assertThat(actual).isEqualTo(4);
    }

    public static Stream<Arguments> matchedCountProvider() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(1, 2, 3, 4, 42, 43)),
                Arguments.of(List.of(1, 2, 3, 4, 15, 24))
        );
    }
}