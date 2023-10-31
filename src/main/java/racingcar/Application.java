package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();
        OutputView outputView = new OutputView();
        CustomArrayList<Car> carList = new CustomArrayList<>();
        List<Car> winnerList = new ArrayList<>();

        outputView.startGame();
        String carsName = racingCarGame.getCarsName();
        String[] carName = racingCarGame.extractCarName(carsName);

        outputView.askNumberOfRace();
        racingCarGame.generateCarList(carName, carList);
        int numberOfRace = racingCarGame.getNumberOfRace();

        outputView.showResultOfEachRace();
        racingCarGame.repeatCarRace(carList, numberOfRace);

        winnerList.add(carList.get(0));
        racingCarGame.decideWinner(carList, winnerList);

        outputView.showWinner();
        racingCarGame.printOutWinner(winnerList);
    }
}
