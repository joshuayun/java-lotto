package lotto.model;

public enum LottoResult {
    NO_PRIZE(0, "일치 없음", "0,false"),
    FIFTH_PRIZE(5000, "3개 일치", "3,false"),
    FOURTH_PRIZE(50000, "4개 일치", "4,false"),
    THIRD_PRIZE(1500000, "5개 일치","5,false"),
    SECOND_PRIZE(30000000, "5개 일치, 보너스 볼 일치", "5,true"),
    FIRST_PRIZE(2000000000, "6개 일치", "6,false");

    private final int reward;
    private final String mention;
    private final String resultKey;
    private int count;



    LottoResult(int reward, String mention, String resultKey) {
        this.reward = reward;
        this.mention = mention;
        this.resultKey = resultKey;
    }
    public int getReward() {
        return reward;
    }
    public String getMention() {
        return mention;
    }
    public String getResultKey() {
        return resultKey;
    }
    public void plusCount() {
        this.count++;
    }
    public int getCount() {
        return count;
    }

}