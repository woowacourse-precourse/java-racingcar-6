package racingcar.dto;

public record RoundResponse(
        String name,
        Integer score
) {
    private static final String DASH = "-";

    public String toResponse() {
        String visualizedScore = DASH.repeat(score);
        return String.format("%s : %s", name, visualizedScore);
    }
}
