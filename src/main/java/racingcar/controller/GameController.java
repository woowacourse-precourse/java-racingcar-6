package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Dice;
import racingcar.model.Game;
import racingcar.model.WinnerList;

public class GameController {

    private final Integer MOVING_FORWARD_NUMBER = 4;

    public Game makeGame(String maxRound) {
        return new Game(maxRound);
    }

    public Dice rollDiceTen() {
        return new Dice(Randoms.pickNumberInRange(0, 9));
    }

    public String judge(Cars cars, Game game) {
        StringBuilder stringBuilder = new StringBuilder();
        while (game.getPresentRoundNumber() < game.getMaxRoundNumber()) {
            stringBuilder.append(gameRoundPlay(cars)).append("\n");
            game.roundNumberPlus();
        }
        return String.valueOf(stringBuilder);
    }

    public String score(Cars cars) {
        return String.join(",", extractWinner(cars).getWinnerList());
    }

    private String gameRoundPlay(Cars cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars.getCars()) {
            Dice dice = rollDiceTen();
            car.addDistance(dice.getDice(), MOVING_FORWARD_NUMBER);
            stringBuilder.append(car.getDistanceLine()).append("\n");
        }
        return String.valueOf(stringBuilder);
    }

    private WinnerList extractWinner(Cars cars) {
        int max = 0;
        List<String> winnerName = new ArrayList<>();
        for (Car c : cars.getCars()) {
            max = Math.max(max, c.getDistance());
        }
        for (Car c : cars.getCars()) {
            winnerValid(c, max, winnerName);
        }
        return new WinnerList(winnerName);
    }

    private static void winnerValid(Car c, int max, List<String> winnerName) {
        if (c.getDistance() == max) {
            winnerName.add(c.getName());
        }
    }
}
