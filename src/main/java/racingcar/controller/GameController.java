package racingcar.controller;

 import camp.nextstep.edu.missionutils.Randoms;
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
        return new Dice(Randoms.pickNumberInRange(0,9));
    }

    public void judge(List<Car> cars, Game game) {
        while (game.getPresentRoundNumber() < game.getMaxRoundNumber()) {
            for (Car car : cars) {
                Dice dice = rollDiceTen();
                car.addDistance(dice.getDice(), MOVING_FORWARD_NUMBER);
                car.getDistanceLine();
            }
            game.roundNumberPlus();
        }
    }
}
