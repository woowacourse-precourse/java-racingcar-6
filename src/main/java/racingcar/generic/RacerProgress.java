package racingcar.generic;

public record RacerProgress(String name, int mileage) {

    public static final String DELIMITER_NAME_AND_MILEAGE = " : ";
    public static final String PROGRESS_MILEAGE = "-";

    @Override
    public String toString() {
        return name + DELIMITER_NAME_AND_MILEAGE + PROGRESS_MILEAGE.repeat(mileage);
    }

}
