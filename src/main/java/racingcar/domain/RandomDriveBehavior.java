package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.function.IntSupplier;

public class RandomDriveBehavior implements DriveBehavior {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int MIN_DRIVE_FORWARD_NUMBER = 4;

    private final IntSupplier randomGenerator;

    public RandomDriveBehavior(IntSupplier randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public void drive(CarPosition carPosition) {
        int randomNumber = randomGenerator.getAsInt();

        if (randomNumber >= MIN_DRIVE_FORWARD_NUMBER) {
            carPosition.driveForward();
        }
    }

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
