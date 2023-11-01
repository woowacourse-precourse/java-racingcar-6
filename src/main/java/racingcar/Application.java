package racingcar;

import static racingcar.util.OutputView.askNamesOfCars;
import static racingcar.util.OutputView.askNumberOfRace;
import static racingcar.util.OutputView.showResultOfRace;
import static racingcar.util.OutputView.showWinner;

import java.util.ArrayList;
import java.util.List;
import racingcar.customCollection.CustomArrayList;
import racingcar.domain.Car;
import racingcar.domain.RacingCarGame;

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
