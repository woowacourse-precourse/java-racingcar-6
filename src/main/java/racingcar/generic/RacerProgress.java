package racingcar.generic;

public record RacerProgress(String name, int mileage) {

    @Override
    public String toString() {
        return name + " : " + "-".repeat(mileage);
    }

}
