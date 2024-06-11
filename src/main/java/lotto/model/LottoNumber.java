package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final List<Integer> LOTTO_RANGE = IntStream.rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    private static final int MAXIMIM_LOTTO_DIGIT = 6;

    private final List<Integer> numbers;

    public LottoNumber() {
        this.numbers = generateNumbers();
    }

    public LottoNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static List<Integer> generateNumbers() {
        return shuffle().subList(0, MAXIMIM_LOTTO_DIGIT)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static List<Integer> shuffle() {
        List<Integer> result = new ArrayList<>(LOTTO_RANGE);
        Collections.shuffle(result);
        return result;
    }
}
