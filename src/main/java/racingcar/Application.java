package racingcar;

import static racingcar.OutputView.askNumberOfRace;
import static racingcar.OutputView.showResultOfEachRaceText;
import static racingcar.OutputView.showWinner;
import static racingcar.OutputView.showWinnerText;
import static racingcar.OutputView.startGame;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();
        CustomArrayList<Car> carList = new CustomArrayList<>();
        List<Car> winnerList = new ArrayList<>();

        startGame();
        String carsName = racingCarGame.getCarsName();
        String[] carName = racingCarGame.extractCarName(carsName);

        askNumberOfRace();
        racingCarGame.generateCarList(carName, carList);
        int numberOfRace = racingCarGame.getNumberOfRace();

        showResultOfEachRaceText();
        racingCarGame.repeatCarRace(carList, numberOfRace);
        racingCarGame.initializeWinnerList(carList, winnerList);
        racingCarGame.decideWinner(carList, winnerList);

        showWinnerText();
        StringBuilder sb = racingCarGame.printOutWinner(winnerList);
        showWinner(sb);
    }
}
