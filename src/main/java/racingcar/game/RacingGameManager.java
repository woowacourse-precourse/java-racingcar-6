package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import racingcar.converter.StringToAttemptCountConverter;
import racingcar.converter.StringToCarListConverter;
import racingcar.game.components.Car;
import racingcar.game.components.GameSetting;

import java.util.List;

import static racingcar.message.GameMessages.*;

/**
 * GameManager - RacingGame을 구동하기 위한 설정 및 실행기
 */
public class RacingGameManager {

    private final RacingGame game = new RacingGame();
    private final StringToCarListConverter stringToCarListConverter = new StringToCarListConverter();
    private final StringToAttemptCountConverter stringToAttemptCountConverter = new StringToAttemptCountConverter();

    public GameSetting setting() {
        System.out.println(GAME_START);
        String carNames = Console.readLine().trim();
        List<Car> carList = stringToCarListConverter.execute(carNames);

        System.out.println(MAX_ATTEMPTS);
        String attemptCountString = Console.readLine();
        int attemptCount = stringToAttemptCountConverter.execute(attemptCountString);

        return new GameSetting(carList, attemptCount);
    }

    public void gameStart() {
        GameSetting setting = setting();
        System.out.println();
        System.out.println(GAME_RESULT);
        game.execute(setting.getCarList(), setting.getAttemptCount());
    }

}
