package lotto.model;


import java.util.List;

public class Lotto {
    private final LottoNumber lottoNumber;

    public Lotto(LottoNumber lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber.getNumbers();
    }

    public boolean contains(int number) {
        return lottoNumber.getNumbers().contains(number);
    }

    public int matchedCount(List<Integer> winningNumbers) {
        return (int) lottoNumber.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
