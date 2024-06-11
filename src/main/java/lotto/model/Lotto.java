package lotto.model;


public class Lotto {

    private final LottoNumber number;

    private LottoResult lottoResult;


    public Lotto(LottoNumber number) {
        this.number = number;
    }

    public LottoNumber getNumber() {
        return number;
    }

    public void setLottoResult(LottoResult lottoResult) {
        this.lottoResult = lottoResult;
    }

}
