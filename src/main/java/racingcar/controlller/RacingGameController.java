package racingcar.controlller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
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
        // 게임 시작 전 필요한 사전 작업 진행
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
            // 한 라운드 진행
            doOneRound();
            // 현재 자동차들의 전진 상태 출력
            OutputView.printCurrentForwardState(carList);
        }
        // 최종 우승자 출력
        OutputView.printWinners(carList.winnersToString());

        // 게임 종료
        isRunning = false;
    }

    private void doOneRound() {
        for (Car car : carList.getCarList()) {
            moveOrNot(car);
        }
    }

    private void moveOrNot(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            car.moveForward(1);
        }
    }
}
