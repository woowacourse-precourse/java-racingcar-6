package racingcar.controller;

import racingcar.model.CarNames;
import racingcar.model.RacingCarGameService;
import racingcar.model.RacingResult;
import racingcar.model.TryCount;
import racingcar.view.RacingCarGameView;

public class RacingCarGameController {

    private RacingCarGameView racingCarGameView;
    private RacingCarGameService racingCarGameService;

    public RacingCarGameController() {
        racingCarGameView = new RacingCarGameView();
        racingCarGameService = new RacingCarGameService();
    }

    public void gameStart() {
        String input = racingCarGameView.inputCarNames();
        CarNames carNames = new CarNames(input);
        int count = racingCarGameView.inputTryCount();
        TryCount tryCount = new TryCount(count);

        RacingResult racingResult = new RacingResult(carNames, tryCount);
        // 시도 횟수만큼 반복
        // 처음 "실행 결과" 출력해야함
        while(tryCount.getCount() > 0) {
            // 시도횟수마다 결과 반환하는 메서드반환
            racingResult = racingCarGameService.continueGame(racingResult);
            // 결과 뿌리는 뷰 호출
            racingCarGameView.printResult(racingResult);
        }

        // 마지막 반환 결과 가지고 우승자 판단

    }
}
