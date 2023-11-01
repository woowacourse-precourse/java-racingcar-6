package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.utils.RandomUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameService {

    private Game game;
    private List<Car> carList = new ArrayList<>();

    RandomUtils randomUtils = new RandomUtils();

    public List<Car> setCarList(String carNames) {
        List<String> carNameList = List.of(carNames.split(","));
        List<Car> carList = new ArrayList<>();

        for (String name : carNameList) {
            carList.add(new Car(name));
        }

        this.carList = carList;
        return carList;
    }

    public void setGame(String raceCountInString) {
        int finalRaceCount = Integer.parseInt(raceCountInString);
        this.game = new Game(finalRaceCount);
    }

    public void playGame() {
        System.out.println("\n실행 결과");
        while (game.isNotGameOver()) {
            moveCar();
            game.setCurrentRaceCount();
        }
    }

    private void moveCar() {
        List<Integer> randomPositionList = randomUtils.getRandomNumberList(carList.size());

        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).moveOrGo(randomPositionList.get(i));
        }
        System.out.println();
    }

    public void winnerChoice() {
        List<String> winnerNameList = new ArrayList<>();
        int winnerPosition = getWinnerPosition();

        for (Car c : carList) {
            if (c.getPosition() == winnerPosition) {
                winnerNameList.add(c.getName());
            }
        }

        printWinner(winnerNameList);
    }

    private int getWinnerPosition() {
        List<Integer> positionList = new ArrayList<>();

        for (Car car : carList) {
            positionList.add(car.getPosition());
        }

        return Collections.max(positionList);
    }

    private void printWinner(List<String> winnerNameList) {
        System.out.print("최종 우승자 : ");

        if (winnerNameList.size() == 1) {
            System.out.println(winnerNameList.get(0));
            return;
        }

        for (int i = 0; i < winnerNameList.size(); i++) {
            System.out.print(winnerNameList.get(i));

            if (i != winnerNameList.size() - 1) {
                System.out.print(", ");
            }
        }
    }


}
