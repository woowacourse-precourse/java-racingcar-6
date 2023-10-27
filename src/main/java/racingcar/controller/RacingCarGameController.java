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
        while(tryCount.getCount() > 0) {
            // 시도횟수마다 결과 반환하는 메서드반환
            racingCarGameService.continue();
            // 결과 클래스는 차 이름들과 그에 매핑되는 진행결과를 정수로 가지고 있어야 함
            // 해당 메서드에서 이전결과를 계속 가지고 있어야 함
        }

        // 최종 결과 출력
        // 마지막 반환 결과 가지고 우승자 판단
    }
}
