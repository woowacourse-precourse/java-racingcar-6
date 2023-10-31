package racingcar.domain;

import static racingcar.domain.InputToCarList.getInstance;

import java.util.List;

public class RacingCarGame {

    private static final String GAME_RESULT = "실행 결과";
    private final Referee referee;

    public RacingCarGame(Referee referee) {
        this.referee = referee;
    }

    public StringBuilder gameStart(String verifiedInput, Integer tryCount) {
        List<Car> carNameList = getInstance().askCarName(verifiedInput);
        StringBuilder gameResult = new StringBuilder();
        gameResult.append(GAME_RESULT).append('\n');

        for (int i = 0; i < tryCount; i++) {
            for (int k = 0; k < carNameList.size(); k++) {
                Car car = carNameList.get(k);
                referee.startEngine(car);
                gameResult.append(car).append('\n');
            }
            gameResult.append('\n');
        }

        List<Car> cars = referee.selectWinnerList(carNameList);
        gameResult.append(referee.winnerName(cars));
        return gameResult;
    }
}
