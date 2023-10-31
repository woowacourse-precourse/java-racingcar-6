package racingcar.data;

import racingcar.execution.GameInput;

public class GameData {
    private final RacingCars racingCars;
    private AttemptData attemptData;
    private static final String DATA_SPLITERATOR = ",";

    public GameData() {
        this.racingCars = new RacingCars();
    }

    public void initRacingCars(String racingCarsData) {
        String[] racingCarsName = racingCarsData.split(DATA_SPLITERATOR);
        for (String racingCarName : racingCarsName) {
            racingCars.createCar(racingCarName);
        }
    }

    public void initAttemptData(String attemptNumberData) {
        int attemptNumber = Integer.parseInt(attemptNumberData);
        this.attemptData = new AttemptData(attemptNumber);
    }

    public void proceedOneRace() {
        attemptData.pickNewNumber(racingCars.isTotal());
    }
}
