package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;



class LottoTest {

    @MethodSource("listProvider")
    @ParameterizedTest
    void lottoNumber(List<Integer> lottoNumber){

    }

    public static Stream<Arguments> listProvider() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(20, 21, 23, 41, 42, 43)),
                Arguments.of(List.of(5,4,6,13,15,24))

        );
    }

}