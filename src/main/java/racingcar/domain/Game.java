package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.utils.Converter;

public class Game {

    private List<Car> carList = new ArrayList<>();
    private List<Car> winners = new ArrayList<>();

    private Player player;
    private Long gameCount;

    public void raceSetting() {
        setPlayer();
        setCarList();
        setGameCount();
    }

    public void race() {
        Output.printRaceResultIntro();
        while (leftGameCount()) {
            gameCount--;
            raceOneTime();
            printEachLocation();
        }
    }

    private void setPlayer() {
        player = new Player();
    }

    private void setCarList() {
        player.inputCarNames();
        List<String> carNames = player.getCarNames();
        carList = Converter.convertStringListToCarList(carNames);
    }

    private void setGameCount() {
        player.inputGameCount();
        gameCount = player.getGameCount();
    }

    private boolean leftGameCount() {
        return gameCount != 0;
    }

    private void raceOneTime() {
        carList.forEach(Car::tryMove);
    }

    private void printEachLocation() {
        carList.forEach(Car::printCurrentLocation);
        System.out.println();
    }

}
