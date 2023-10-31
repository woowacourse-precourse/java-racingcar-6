package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.function.IntSupplier;

public class RandomDriveBehavior implements DriveBehavior {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int MIN_DRIVE_FORWARD_NUMBER = 4;
    private static final int DRIVE_FORWARD_DISTANCE = 1;
    private static final int NO_DRIVE_DISTANCE = 0;
    private static final String RANDOM_NUMBER_EXCEPTION_MESSAGE =
            String.format("Error: 무작위 값은 %d에서 %d 사이의 숫자여야 합니다.", MIN_NUMBER, MAX_NUMBER);

    private final IntSupplier randomGenerator;

    public RandomDriveBehavior(IntSupplier randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public int determineDistance() {
        int randomNumber = randomGenerator.getAsInt();
        validateRandomNumber(randomNumber);

        if (randomNumber >= MIN_DRIVE_FORWARD_NUMBER) {
            return DRIVE_FORWARD_DISTANCE;
        }

        return NO_DRIVE_DISTANCE;
    }

    private void validateRandomNumber(int randomNumber) {
        if (randomNumber < MIN_NUMBER || randomNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(RANDOM_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
