package racingcar.domain.racingcargame;

public class Winner {

    // 승자를 저장하는 필드
    String winner;

    // 가장 멀리 간 거리를 저장하는 필드
    int max;

    public Winner() {
        this.winner = "";
        this.max = 0;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
