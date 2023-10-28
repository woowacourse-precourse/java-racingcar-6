package racingcar.domain;

import java.util.List;

public class Game {

    public void racingGame() {
        Output.printCarInputMessage();
        String[] carArray = Input.getCars();
        Output.printTryCountInputMessage();
        int tryCount = Input.getTryCount();

        System.out.println("실행 결과");
        Cars cars = new Cars(carArray);
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars();
            cars.printCarPosition();
        }
        List<String> victoryCarsName = cars.getVictoryCarsName();
        Output.printVictoryCarNames(victoryCarsName);
    }
}
