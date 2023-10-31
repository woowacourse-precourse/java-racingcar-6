package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.util.InputValidation;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GameController {
    int gameRound;
    List<String> cars = new ArrayList<>();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    InputValidation inputValidation = new InputValidation();
    public void startGame() {

        // 자동차 이름 입력 요청
        String inputCarName = inputView.CarName();
        inputValidation.isVaildCarName(inputCarName);
        // 시도할 회수 입력 요청
        String inputGameRound = inputView.GameRound();
        // 입력값 검증
        inputValidation.isVaildGameRound(inputGameRound);

        setGame(inputCarName, inputGameRound);
        System.out.println(gameRound);
        System.out.println(cars);
        // playGame();
    }

    private void setGame(String inputCarName, String inputGameRound) {
        setCars(inputCarName);
        setRound(inputGameRound);
    }

    private void setCars(String inputCarName) {
        String[] arrCar = inputCarName.split(",");
        this.cars = Arrays.asList(arrCar);
    }
    private void setRound(String inputGameRound) {
        this.gameRound = Integer.parseInt(inputGameRound);
    }


    public void playGame() {
        // 실행 결과 메세지 출력
        // 회차별 게임 진행
        // 1.난수 발생
        // 2.자동차 이동
        // 3.회차 결과 출력
        // endGame();
    }
    public void endGame() {
        // 최종 우승자 선발
        // 최종 우승자 출력
    }
}
