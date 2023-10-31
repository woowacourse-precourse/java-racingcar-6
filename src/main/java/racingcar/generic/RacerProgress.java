package racingcar.generic;

public record RacerProgress(String name, int mileage) {

    @Override
    public String toString() {
        // TODO : 리터럴 상수 제거
        return name + " : " + "-".repeat(mileage);
    }

}
