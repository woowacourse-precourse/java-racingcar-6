package racingcar.domain.game;

import java.util.List;
import racingcar.domain.racing.Racing;
import racingcar.domain.raingcar.RacingCars;
import racingcar.view.RacingGameInputView;
import racingcar.view.RacingGameOutputView;

public class RacingGame {
    private RacingGameInputView inputView = new RacingGameInputView();
    private RacingGameOutputView outputView = new RacingGameOutputView();

    public void start() {
        // 자동차 이름 입력
        outputView.printCarNameInputMessage();
        String[] inputCars = inputView.nextStringArray();

        // 시도할 회수 입력
        outputView.printRacingRoundInputMessage();
        int round = RacingGameInputView.nextInt();

        // 레이싱
        RacingCars cars = RacingCars.fromNames(inputCars);
        Racing racing = new Racing(cars, round);
        racing.process();

        // 실행 결과 출력
        outputView.println(racing.getTotalRacingResult());

        // 최종 우승자 출력
        List<String> finalWinners = racing.getFinalWinnerList();
        outputView.printFinalWinnerAnnouncedMessage(finalWinners);

    }
}
