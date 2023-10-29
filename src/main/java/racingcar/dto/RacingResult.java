package racingcar.dto;

public record RacingResult(String name, String position) {
    public RacingResult(String name, int movedCount) {
        this(name, "-".repeat(movedCount));
    }
}
