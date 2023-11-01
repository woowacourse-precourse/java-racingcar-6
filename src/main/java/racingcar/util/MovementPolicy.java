package racingcar.util;

public class MovementPolicy {
    private static final int STANDARD_NUMBER = 4;

    private static int getRandomNumber() {
        return RandomNumberGenerator.generate();
    }

    public boolean isAvailableToGo() {
        int randomNumber = getRandomNumber();

//        System.out.println("randomNumber = " + randomNumber);

        boolean goOrNot = randomNumber >= STANDARD_NUMBER;

        return goOrNot;
    }
}
