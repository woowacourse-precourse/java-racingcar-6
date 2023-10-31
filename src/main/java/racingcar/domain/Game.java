package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.Converter;
import racingcar.utils.Output;

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

    public void declareWinner() {
        winners = selectWinner();
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

    private List<Car> selectWinner() {
        Long winnersCount = findMaxCount();
        return carList.stream()
                .filter(car -> car.getForwardCount().equals(winnersCount))
                .collect(Collectors.toList());
    }

    private Long findMaxCount() {
        return carList.stream()
                .map(Car::getForwardCount)
                .max(Long::compareTo)
                .orElse(0L);
    }

}
