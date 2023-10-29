package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.CarMovement;
import racingcar.domain.CarStore;
import racingcar.dto.Car;
import racingcar.view.InputVeiw;
import racingcar.view.OutputView;

/**
 * RoundController를 분리 Service 분리
 */
public class GameController {
    private static final InputVeiw inputView = new InputVeiw();
    private static final CarStore carStore = CarStore.getInstance();

    private int MAX_CAR_NUMBER;
    private int MAX_ROUND;
    private int currentRound;

    /**
     * 역할 분리 for문 stream으로 수정
     */
    public void run() {
        getCarNameInput(inputView.inputCarName());
        getTotalRoundInput(inputView.inputRoundNumber());

        startGame();
    }

    private void getTotalRoundInput(Integer integer) {
        MAX_ROUND = integer;
    }

    private void getCarNameInput(List<String> carList) {
        MAX_CAR_NUMBER = carList.size();
        IntStream.range(0, MAX_CAR_NUMBER)
                .mapToObj(i -> new Car(i, carList.get(i), 0))
                .forEach(carStore::saveCarInfo);
    }

    private void startGame() {
        do {
            increaseCurrentRound();

            // 게임 수행
            startRound();

        } while (getCurrentRound() < MAX_ROUND);

        // 우승자 출력
        OutputView.printGameWinner(carStore.findAllCar());
    }

    /**
     * 랜덤값 추출하는 역할 따로 분리 for문 stream으로 변경 Game에게 go/stop에 대한 책임을 넘기기
     */
    private void startRound() {
        IntStream.range(0, MAX_CAR_NUMBER)
                .mapToObj(carStore::getCarInfo)
                .map(CarMovement::new)
                .map(CarMovement::car)
                .forEach(OutputView::printStatusOfRaceCar);
        System.out.println();
    }

    public void increaseCurrentRound() {
        currentRound += 1;
    }

    public int getCurrentRound() {
        return currentRound;
    }

}