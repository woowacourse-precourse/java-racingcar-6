package racingcar.controller;

import java.util.List;
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
        // 차이름, 횟수 입력받기
        List<String> tmp = inputView.inputCarName();
        for (int i = 0; i < tmp.size(); i++) {
            Car car = new Car(i, tmp.get(i), 0);
            carStore.saveCarInfo(car);
        }
        MAX_CAR_NUMBER = tmp.size();
        MAX_ROUND = inputView.inputRoundNumber();

        startGame();
    }

    private void startGame() {
        // while 라운드 체크 하며, 게임 수행
        do {
            increaseCurrentRound();

            // 게임 수행
            startRound();
            System.out.println();

        } while (getCurrentRound() < MAX_ROUND);

        // 우승자 출력
        OutputView.printGameWinner(carStore.findAllCar());
    }

    /**
     * 랜덤값 추출하는 역할 따로 분리 for문 stream으로 변경 Game에게 go/stop에 대한 책임을 넘기기
     */
    private void startRound() {
        // 조건 충족시, raceCar 이동
        for (int i = 0; i < MAX_CAR_NUMBER; i++) {
            Car currentRaceCar = carStore.getCarInfo(i);
            new CarMovement(currentRaceCar);
            OutputView.printStatusOfRaceCar(carStore.getCarInfo(i));
        }
    }

    public void increaseCurrentRound() {
        currentRound += 1;
    }

    public int getCurrentRound() {
        return currentRound;
    }

}