package racingcar.dto.output;

public record RoundDTO(String name, int distance) {

    @Override
    public String toString() {
        return name
                + " : "
                + "-".repeat(Math.max(0, distance));
    }
}
