package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class GameController {
    private static final int RANDOM_START_RANGE = 0;
    private static final int RANDOM_END_RANGE = 9;
    private static final int MOVE_POSSIBLE_RANGE = 4;

    public static void setCars() {
        View.inputMessageOfCar();
        Input.getCarInformation().forEach(Model::setCar);
    }

    public static void setNumberOfTries() {
        View.inputMessageOfTries();
        Model.setNumberOfTries(Input.getTriesInformation());
    }

    public static void moveForward() {

    }

    private static void tryMoveForward(Car car) {

    }

    private static boolean isCanMove() {

    }
}
