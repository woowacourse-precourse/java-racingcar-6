package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();
        OutputView outputView = new OutputView();
        CustomArrayList<Car> carList = new CustomArrayList<>();

        outputView.startGame();
        String carsName = racingCarGame.getCarsName();
        String[] carName = racingCarGame.extractCarName(carsName);

        outputView.askNumberOfRace();
        racingCarGame.generateCarList(carName, carList);
        int numberOfRace = racingCarGame.getNumberOfRace();

        outputView.showResultOfEachRace();
        racingCarGame.repeatCarRace(carList, numberOfRace);
        List<Car> winner = racingCarGame.decideWinner(carList);

        outputView.showWinner();
        racingCarGame.printOutWinner(winner);
    }
}
