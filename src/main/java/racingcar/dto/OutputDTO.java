package racingcar.dto;

public record OutputDTO(String name, int moveCount) {

    @Override
    public String toString() {
        return name
                + " : "
                + "-".repeat(Math.max(0, moveCount));
    }
}
