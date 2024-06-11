package lotto.model;

public enum LottoResult {
    NO_PRIZE(0, "일치 없음"),
    FIFTH_PRIZE(5000, "3개 일치"),
    FOURTH_PRIZE(50000, "4개 일치"),
    THIRD_PRIZE(1500000, "5개 일치"),
    SECOND_PRIZE(30000000, "5개 일치, 보너스 볼 일치"),
    FIRST_PRIZE(2000000000, "6개 일치");

    private final int reward;
    private final String matched;
    private int count;

    LottoResult(int reward, String matched) {
        this.reward = reward;
        this.matched = matched;
    }

    public int getReward() {
        return reward;
    }
    public String getMatched() {
        return matched;
    }

    public void plusCount() {
        this.count++;
    }
    public int getCount() {
        return count;
    }

}