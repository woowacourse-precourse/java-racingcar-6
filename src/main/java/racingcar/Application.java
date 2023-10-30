package racingcar;

public class Application {
    public static void main(String[] args) {
        Car car = new Car(InputView.carName());
        RacingCarGameConsole racingCarGameConsole = new RacingCarGameConsole(car, InputView.timesToTry());
        racingCarGameConsole.run();
    }
}
