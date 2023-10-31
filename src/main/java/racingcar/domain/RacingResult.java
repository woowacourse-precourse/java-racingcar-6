package racingcar.domain;

public class RacingResult {
    private String result = "";

    public void forward() {
        this.result += "-";
    }

    public String toString() {
        return result;
    }
}
