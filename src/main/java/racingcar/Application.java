package racingcar;

import racingcar.core.*;
import racingcar.domain.Car;
import racingcar.domain.CarFactory;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        Output output = new Output();
        CarFactory factory = new CarFactory();
        GameProgressSystem progressSystem = new GameProgressSystem();
        WinnerCheckSystem winnerCheckSystem = new WinnerCheckSystem();
        GameAwards gameAwards = new GameAwards(winnerCheckSystem);
        GameManager gameManager = new GameManager(input,output,factory,progressSystem,winnerCheckSystem,gameAwards);

        gameManager.play();
    }
}
