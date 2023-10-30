package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        Car car = new Car();
        Play play = new Play();
        Score score = new Score();

        List<String> carNames = input.carNameInput();
        List<Car> Cars = car.createCars(carNames);

        int round = input.roundNumInput();
        while(round>0) {
            Cars = play.playRound(Cars);
            score.printRoundResult(Cars);
            round--;
        }
        score.printWinnerResult(Cars);
    }
}
