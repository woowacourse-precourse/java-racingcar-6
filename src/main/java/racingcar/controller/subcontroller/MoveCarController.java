package racingcar.controller.subcontroller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.repository.CarRepository;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MoveCarController {
    private final InputView inputView;
    private final OutputView outputView;

    public MoveCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void moveCar() {
        int attemptCount = inputAttemptToMoveCar(); // 이동을 시도할 횟수 입력
        repeatAttemptAsCount(attemptCount);
    }

    private void repeatAttemptAsCount(int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            attemptToMoveCar(); // 이동 시도
            outputMovingRecord(); // 시도 후 이동 기록 출력
        }
    }

    private void outputMovingRecord() {
        outputView.outputMovingRecord();
        System.out.println();
    }

    private void attemptToMoveCar() {
        for (Car car : CarRepository.cars()) {
            int rand = Randoms.pickNumberInRange(0, 9); // random
            if (rand >= 4) {
                car.addMoveCount();
            }
        }
    }

    private int inputAttemptToMoveCar() {
        return inputView.inputAttemptToMoveCar();
    }
}