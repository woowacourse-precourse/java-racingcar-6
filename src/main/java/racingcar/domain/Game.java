package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class Game {
    Cars carList;
    int tryChance;
    Map<String, Integer> gameResult;

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
        for(Car car : carList.getCars()) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
        gameResult = carList.getResultOfRound();
    }

    private void isNumericInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    private void isGreaterThanZero(String input) {
        int chance = Integer.parseInt(input);
        if(chance <= 0) {
            throw new IllegalArgumentException("0보다 큰 숫자를 입력해야 합니다.");
        }
    }
}
