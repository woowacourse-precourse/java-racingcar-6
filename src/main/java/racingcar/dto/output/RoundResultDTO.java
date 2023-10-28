package racingcar.dto.output;

public record RoundResultDTO(String name, int moveCount) {

    @Override
    public String toString() {
        return name
                + " : "
                + "-".repeat(Math.max(0, moveCount));
    }
}
