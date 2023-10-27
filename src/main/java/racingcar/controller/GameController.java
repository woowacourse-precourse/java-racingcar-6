package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarName;
import racingcar.model.Cars;
import racingcar.model.Dice;
import racingcar.model.DiceNumber;
import racingcar.model.Distance;
import racingcar.model.Game;
import racingcar.model.MaxRoundNumber;
import racingcar.model.PresentRoundNumber;
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
        MaxRoundNumber maxRoundNumber = game.getMaxRoundNumber();
        while (getGamePresentRoundNumber(game) < maxRoundNumber.getRawMaxRoundNumber()) {
            stringBuilder.append(gameRoundPlay(cars)).append("\n");
            game.roundNumberPlus();
        }
        return String.valueOf(stringBuilder);
    }

    private int getGamePresentRoundNumber(Game game) {
        return game.getPresentRoundNumber().getRawPresentRoundNumber();
    }

    public String score(Cars cars) {
        return String.join(",", extractWinner(cars).getWinnerList());
    }

    private String gameRoundPlay(Cars cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars.getCars()) {
            DiceNumber diceNumber = rollDiceTen().getDiceNumber();
            car.forward(diceNumber.getRawDiceNumber(), MOVING_FORWARD_NUMBER);
            stringBuilder.append(car.getDistanceLine()).append("\n");
        }
        return String.valueOf(stringBuilder);
    }

    private WinnerList extractWinner(Cars cars) {
        int max = 0;
        List<String> winnerName = new ArrayList<>();
        for (Car c : cars.getCars()) {
            Distance distance = c.getDistance();
            max = Math.max(max, distance.getDistance());
        }
        for (Car c : cars.getCars()) {
            winnerValid(c, max, winnerName);
        }
        return new WinnerList(winnerName);
    }

    private static void winnerValid(Car c, int max, List<String> winnerName) {
        Distance distance = c.getDistance();
        if (distance.getDistance() == max) {
            CarName carName = c.getName();
            winnerName.add(carName.getRawName());
        }
    }
}
