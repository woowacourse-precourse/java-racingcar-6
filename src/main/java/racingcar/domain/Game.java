package racingcar.domain;

import static racingcar.common.Validator.isGreaterThanZero;
import static racingcar.common.Validator.isNumericInput;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class Game {
    private final Cars carList;
    private int tryChance;
    private Map<String, Integer> gameResult;

    public Game(Cars cars) {
        this.carList = cars;
    }

    public int getChanceNumber() {
        return tryChance;
    }

    public Cars getCars() {
        return carList;
    }

    public Map<String, Integer> getGameResult() {
        return gameResult;
    }

    public void settingChance(String chance) {
        isNumericInput(chance);
        isGreaterThanZero(chance);
        this.tryChance = Integer.parseInt(chance);
    }

    public void running() {
        for(Car car : carList.getCarList()) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
        gameResult = carList.getResultOfRound();
    }

    public boolean stillInPlaying(int round) {
        return round <= tryChance;
    }
}
