package racingcar.data.attempt;

import java.util.List;
import racingcar.data.car.RacingCars;

public class Attempt {
    private final RacingCars racingCars;
    private RandomNumbers randomNumbers;
    private static final int FORWARD_THRESHOLD = 4;
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

    public String decideMoves() {
        StringBuilder moves = new StringBuilder();
        for (int i = 0; i < racingCars.isTotal(); i++) {
            if (isForward(randomNumbers.toIntByIndex(i))) {
                moves.append("1");
            }
            if (isStop(randomNumbers.toIntByIndex(i))) {
                moves.append("0");
            }
        }
        return moves.toString();
    }

    public void moveRacingCars(String moves) {
        for (int i = 0; i < moves.length(); i++) {
            int move = Character.getNumericValue(moves.charAt(i));
            racingCars.moveCar(i, Move.getNumByMove(move));
        }
    }

    public boolean isForward(int number) {
        return number >= FORWARD_THRESHOLD;
    }

    public boolean isStop(int number) {
        return number < FORWARD_THRESHOLD;
    }

    public List<String> getWinners() {
        int furthestPos = racingCars.findFurthestPos();
        return racingCars.findPlayersByPos(furthestPos);
    }

    @Override
    public String toString() {
        return racingCars.toString();
    }
}
