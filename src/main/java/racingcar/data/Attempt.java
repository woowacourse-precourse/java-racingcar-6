package racingcar.data;

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
        String moves = "";
        for (int i = 0; i < racingCars.isTotal(); i++) {
            if (isForward(randomNumbers.toIntByIndex(i))) {
                moves += "1";
                continue;
            }
            if (isStop(randomNumbers.toIntByIndex(i))) {
                moves += "0";
                continue;
            }
        }
        return moves;
    }

    public void moveRacingCars(String moves) {
        for (int i = 0; i < moves.length(); i++) {
            int move = Character.getNumericValue(moves.charAt(i));
            racingCars.moveCar(i, Move.getNumByMove(move));
        }
    }

    public boolean isForward(int number) {
        if (number >= FORWARD_THRESHOLD) {
            return true;
        }
        return false;
    }

    public boolean isStop(int number) {
        if (number < FORWARD_THRESHOLD) {
            return true;
        }
        return false;
    }
}
