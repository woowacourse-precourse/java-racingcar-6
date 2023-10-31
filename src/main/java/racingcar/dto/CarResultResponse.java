package racingcar.dto;

public record CarResultResponse(String carName, int movingCount) {

    @Override
    public String toString() {
        return String.format("%s : %s", carName, "-".repeat(movingCount));
    }
}
