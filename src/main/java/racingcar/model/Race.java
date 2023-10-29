package racingcar.model;

public class Race {
    private int numberOfRace;
    private final static String TOO_MUCH_NUMBER_OF_RACE = "너무 많은 회수를 입력하였습니다.";

    public Race(int numberOfRace) {
        validateNumberOfRace(numberOfRace);
        this.numberOfRace = numberOfRace;
    }

    private void validateNumberOfRace(int numberOfRace) {
        if (numberOfRace > 100) {
            throw new IllegalArgumentException(TOO_MUCH_NUMBER_OF_RACE);
        }
    }
}
