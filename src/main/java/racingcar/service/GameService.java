package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.utils.RandomUtils;
import racingcar.view.ForInputMessage;
import racingcar.view.OutputMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameService {

    private Game game = new Game();
    RandomUtils randomUtils = new RandomUtils();

    public void initCarList() {
        String carNameListString = ForInputMessage.forInputCarNamesMessage();
        game.setCar(carNameListString);

        String finalRaceCount = ForInputMessage.forInputRaceCountMessage();
        game.setFinalRaceCount(finalRaceCount);
    }


    public void runGame() {
        OutputMessage.printGameResultMessage();
        runGameRaceCountTimes();
    }

    private void runGameRaceCountTimes() {
        while (game.isNotGameOver()) {
            moveCarPosition();
            game.setCurrentRaceCount();
            moveCarPrintResult();
        }
    }

    private void moveCarPosition() {
        List<Car> carList = game.getCarList();
        List<Integer> randomNumberList = randomUtils.getRandomNumberList(carList.size());

        for (int i = 0; i < carList.size(); i++) {
            if (randomNumberList.get(i) >= 4) {
                carList.get(i).movePosition();
            }
        }
    }

    private void moveCarPrintResult() {
        for (Car car : game.getCarList()) {
            OutputMessage.printRandomPlayResultPositionMessage(car);
        }
        OutputMessage.printLn();
    }

    public void choiceWinner() {
        List<Car> winnerList = new ArrayList<>();
        int maxPosition = choiceMaxPosition();

        for (Car c : game.getCarList()) {
            if (c.getPosition() == maxPosition) {
                winnerList.add(c);
            }
        }

        OutputMessage.printWinnerMessage(winnerList);
    }

    private int choiceMaxPosition() {

        List<Integer> positionList = new ArrayList<>();
        for (Car c : game.getCarList()) {
            positionList.add(c.getPosition());
        }

        return Collections.max(positionList);
    }
}
