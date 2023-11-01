package racingcar.controller;

import racingcar.entity.RacingCarEntity;
import racingcar.service.PlayGameService;
import racingcar.service.PrintResultService;
import racingcar.service.UserInputService;

import java.util.List;

public class RacingCarController {
    private final PlayGameService playGameService;
    private final UserInputService userInputService;

    private final PrintResultService printGameResult;


    public RacingCarController(){
        playGameService = new PlayGameService();
        userInputService = new UserInputService();
        printGameResult = new PrintResultService();
    }

    public void gameStart(){
        // 1. car ',' 기준으로 입력받음
        List<RacingCarEntity> cars = userInputService.getRacingCarEntities();
        // 2. 경기 라운드 입력받음
        Integer tryCount = userInputService.getTryCount();
        // 3. 게임 진행
        playGameService.playGame(cars, tryCount);
        // 4. 게임 결과 출력
        printGameResult.printGameResult(cars);
    }

}
