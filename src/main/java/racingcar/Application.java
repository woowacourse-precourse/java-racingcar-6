package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CreateCar createCar = new CreateCar();
        createCar.createdCar(createCar.input());
        RacingRound racingRound = new RacingRound();
        racingRound.attemptCount();

    }
}
