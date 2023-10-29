package racingcar;

import camp.nextstep.edu.missionutils.Console;
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

    public Map<String, Integer> getGameResult() {
        return gameResult;
    }

    public void settingChance() {
        this.tryChance = Integer.parseInt(Console.readLine());
        carList.settingLogBoard(tryChance);
    }

    public void running() {
        for(Car car : carList.getCars()) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.moveOrNot(randomNumber);
        }
        gameResult = carList.getResultOfRound();
    }
}
