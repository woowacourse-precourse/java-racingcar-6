package Controller;

import Model.Car;
import Model.CarList;
import Model.RaceCarNames;
import Model.TryCount;
import View.GameView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GameController {
    private CarList carList;
    private TryCount tryCount;

    public GameController(CarList carList, TryCount tryCount) {
        this.carList = carList;
        this.tryCount = tryCount;
    }

    public void startRacingGame() {
        receiveRaceCarNames();
        receiveTryCount();

        GameView.printGameResultMessage();
        int gameCycle = tryCount.parseInt();
        for (int i = 1; i <= gameCycle; i++) {
            playGame();
            showCarPositions();
        }

        showRaceWinners();
    }

    public void receiveRaceCarNames() {
        String raceCarNamesInput = GameView.getRaceCarNames();
        RaceCarNames raceCarNames = new RaceCarNames(raceCarNamesInput);

        List<String> carNameList = raceCarNames.parseCarNamesFromInput();
        for (String carName : carNameList) {
            Car car = new Car(carName);
            if (!car.isNameValid()) {
                throw new IllegalArgumentException();
            }
            carList.addCar(car);
        }
    }

    public void receiveTryCount() {
        String tryCountInput = GameView.getTryCount();
        tryCount = new TryCount(tryCountInput);

        if (!tryCount.isNumeric()) {
            throw new IllegalArgumentException();
        }
    }

    public void playGame() {
        for (int i = 0; i < carList.getSize(); i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                Car car = carList.getCar(i);
                car.moveForward();
            }
        }
    }

    public void showCarPositions() {
        for (int i = 0; i < carList.getSize(); i++) {
            Car car = carList.getCar(i);
            GameView.printCarState(car);
        }
        GameView.printLine();
    }

    public void showRaceWinners() {
        CarList raceWinners = new CarList();

        int maxPosition = 0;
        for (int i = 0; i < carList.getSize(); i++) {
            Car car = carList.getCar(i);
            int position = car.getPosition();
            if (maxPosition < position) {
                maxPosition = position;
            }
        }

        for (int i = 0; i < carList.getSize(); i++) {
            Car car = carList.getCar(i);
            int position = car.getPosition();
            if (maxPosition == position) {
                raceWinners.addCar(car);
            }
        }

        GameView.printRaceWinners(raceWinners);
    }
}
