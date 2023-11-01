package racingcar;

import static racingcar.OutputView.askNamesOfCars;
import static racingcar.OutputView.askNumberOfRace;
import static racingcar.OutputView.showResultOfRace;
import static racingcar.OutputView.showWinner;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();
        CustomArrayList<Car> carList = new CustomArrayList<>();
        List<Car> winnerList = new ArrayList<>();

        askNamesOfCars();
        String namesOfCars = racingCarGame.readNamesOfCars();
        String[] arrayOfCarName = racingCarGame.splitNamesOfCars(namesOfCars);
        racingCarGame.generateCarList(arrayOfCarName, carList);

        askNumberOfRace();
        int numberOfRace = racingCarGame.readNumberOfRace();

        showResultOfRace();
        racingCarGame.repeatCarRace(carList, numberOfRace);
        racingCarGame.initializeWinnerList(carList, winnerList);
        racingCarGame.judgeWinner(carList, winnerList);

        showWinner();
        racingCarGame.printOutWinner(winnerList);
    }
}
