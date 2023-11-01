package racingcar;

import java.util.List;
import racingcar.common.generator.NsRandomGenerator;
import racingcar.common.generator.RandomGenerator;
import racingcar.common.strategy.MoveStrategy;
import racingcar.common.strategy.RandomMoveStrategy;
import racingcar.common.type.Names;
import racingcar.common.type.TrialCount;
import racingcar.controller.Game;
import racingcar.controller.Racing;
import racingcar.controller.Result;
import racingcar.domain.Car;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingWinners;
import racingcar.dto.input.InputDTO;
import racingcar.view.InputView;

/**
 * 게임을 시작하고 관리하는 클래스
 */
public class GameLauncher {

    private GameLauncher() {
        throw new AssertionError();
    }

    //게임 실행
    public static void run() {
        //사용자로부터 입력을 읽음
        InputDTO userInput = readInput();

        //입력에 따라 레이싱 게임을 설정
        Racing racingGame = setupRacingGame(userInput);

        //설정된 레이싱 게임을 시작
        startRacing(racingGame, userInput.getTrialCount());
    }

    // 사용자로부터 입력을 읽음
    private static InputDTO readInput() {
        return InputView.readUserInput();
    }

    // 레이싱 게임을 시작
    private static void startRacing(Racing racingGame, TrialCount trialCount) {
        racingGame.start(trialCount);
    }

    // 레이싱 게임을 초기 설정
    private static Racing setupRacingGame(InputDTO userInput) {
        List<Car> cars = generateCars(userInput.getNames());
        MoveStrategy moveStrategy = createMoveStrategy();

        // 레이싱 참가 차량과 움직임 전략을 조립
        RacingCars racingCars = RacingCars.of(cars, moveStrategy);

        // 레이싱에서 이길 수 있는 차량을 설정
        RacingWinners racingWinners = RacingWinners.of(cars);

        return assembleRacing(racingCars, racingWinners);
    }

    // 차량 목록을 생성
    private static List<Car> generateCars(Names names) {
        return Car.createCarList(names);
    }

    // 움직임 전략을 생성, 랜덤 생성기를 DI
    private static MoveStrategy createMoveStrategy() {
        RandomGenerator randomGenerator = NsRandomGenerator.of();
        return RandomMoveStrategy.of(randomGenerator);
    }

    // Racing 객체를 조립하여 반환
    private static Racing assembleRacing(RacingCars racingCars, RacingWinners racingWinners) {
        Game game = Game.of(racingCars);
        Result result = Result.of(racingWinners);
        return Racing.of(game, result);
    }
}
