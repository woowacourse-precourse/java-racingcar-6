package racingcar.controlller;

import racingcar.model.CarList;
import racingcar.view.OutputView;

public class RacingGameController extends GameController {
    private CarList carList;
    private int numberOfRounds;

    public RacingGameController(boolean isRunning) {
        super(isRunning);
    }

    @Override
    public void init() {
        // 게임 시작 후 필요한 객체들 생성
    }

    @Override
    public void run() {
        init();
        while (isRunning) {
            startGame();
        }
    }

    @Override
    public void startGame() {
        // 경주할 자동차 이름 입력 받기
        carList = RacingGameInputController.scanCarList();
        // 시도할 회수 입력 받기
        numberOfRounds = RacingGameInputController.scanNumberOfRounds();

        // n라운드 진행
        OutputView.printResultMessage();    // 실행 결과
        for (int i = 0; i < numberOfRounds; i++) {
            // 게임 진행
            doOneRound();
            // 최종 우승자 출력
            OutputView.printCurrentState(carList);
        }
        // 게임 종료
        isRunning = false;
    }

    private void doOneRound() {
    }
}
