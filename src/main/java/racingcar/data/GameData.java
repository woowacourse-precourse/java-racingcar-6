package racingcar.data;

import racingcar.execution.GameInput;

public class GameData {
    private final RacingCars racingCars;
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
}
