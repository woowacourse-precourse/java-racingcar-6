package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Dice;
import racingcar.model.Game;

public class GameController {

    private final Integer MOVING_FORWARD_NUMBER = 4;

    public Game makeGame(String maxRound) {
        return new Game(maxRound);
    }

    public Dice rollDiceTen() {
        return new Dice(Randoms.pickNumberInRange(0, 9));
    }

    public void judge(List<Car> cars, Game game) {
        while (game.getPresentRoundNumber() < game.getMaxRoundNumber()) {
            gameRoundPlay(cars);
            game.roundNumberPlus();
        }
    }

    public String score(List<Car> cars) {
        return String.join(",", extractWinner(cars));
    }

    private void gameRoundPlay(List<Car> cars) {
        for (Car car : cars) {
            Dice dice = rollDiceTen();
            car.addDistance(dice.getDice(), MOVING_FORWARD_NUMBER);
            car.getDistanceLine();
        }
    }

    private List<String> extractWinner(List<Car> cars) {
        int max = 0;
        List<String> winnerName = new ArrayList<>();
        for (Car c : cars) {
            max = Math.max(max, c.getDistance());
        }
        for (Car c : cars) {
            winnerValid(c, max, winnerName);
        }
        return winnerName;
    }

    private static void winnerValid(Car c, int max, List<String> winnerName) {
        if (c.getDistance() == max) {
            winnerName.add(c.getName());
        }
    }
}
