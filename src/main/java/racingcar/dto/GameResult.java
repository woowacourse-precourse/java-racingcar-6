package racingcar.dto;

public record GameResult(String name, String position) {
    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }
}
