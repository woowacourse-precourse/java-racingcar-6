package racingcar.dto.output;

public record CarInfo(String name, int moveCount) {

    @Override
    public String toString() {
        return name
                + " : "
                + "-".repeat(Math.max(0, moveCount));
    }
}
