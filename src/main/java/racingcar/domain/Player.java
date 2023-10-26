package racingcar.domain;

public class Player {

    private static final String CAR_NAME_SEPARATOR = ",";

    private final String namesOfCars;

    public Player(String namesOfCars) {
        this.namesOfCars = namesOfCars;
    }

    public String[] splitNamesOfCars() {
        return namesOfCars.split(CAR_NAME_SEPARATOR);
    }
}
