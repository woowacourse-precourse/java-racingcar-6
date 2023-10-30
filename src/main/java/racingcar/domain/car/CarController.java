package racingcar.domain.car;

public class CarController {

    private static boolean canForward(int randomNumber, int forwardNumber) {
        return randomNumber >= forwardNumber;
    }

    public static void move(Car car, int randomNumber, int forwardNumber) {
        if (canForward(randomNumber, forwardNumber))
            car.forward();
    }
}
