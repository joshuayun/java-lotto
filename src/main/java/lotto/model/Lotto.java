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
}
