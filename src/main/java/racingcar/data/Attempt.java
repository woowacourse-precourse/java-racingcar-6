package racingcar.data;

public class Attempt {
    private final RacingCars racingCars;
    private RandomNumbers randomNumbers;
    private static final String RACING_CAR_NAME_DATA_SPLITERATOR = ",";

    public Attempt() {
        this.racingCars = new RacingCars();
    }

    public Attempt(Attempt prevAttempt) {
        this.racingCars = new RacingCars(prevAttempt.racingCars);
    }

    public void initRacingCars(String racingCarNameData) {
        String[] racingCarsName = racingCarNameData.split(RACING_CAR_NAME_DATA_SPLITERATOR);
        for (String racingCarName : racingCarsName) {
            racingCars.createCar(racingCarName);
        }
    }

    public void initRandomNumbers() {
        randomNumbers = new RandomNumbers(racingCars.isTotal());
        randomNumbers.init();
    }
}
