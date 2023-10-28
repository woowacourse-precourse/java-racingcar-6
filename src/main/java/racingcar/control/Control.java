package racingcar.control;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Cars;
import racingcar.util.CarService;
import racingcar.util.Validation;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Control {
    static List<Integer> carPositions;
    static int maxPosition;
    String[] carNames;
    int rounds;

    // 여기 Control 클래스는 private으로 최대한 써보자! -> 어차피 Model, View로 못 나가니까!
    // main 메서드인 playGame() 먼저 만들고 후에 이 클래스 내에서 나누기
    // Cars 입력받고 List에 넣어주는 메서드도 여기서 구현할 것
    // Winner 판별하는 메서드도 여기

    private void startGame() {
        // 차 이름 입력 받기
        String input = InputView.requestCarName();
        carNames = Cars.makeCarList(input);
        Validation.validateNameInput(carNames);
        // 라운드 수 입력 받기
        String roundInput = InputView.requestRoundNumber();
        rounds = Integer.parseInt(roundInput);
        Validation.validateNumber(rounds);
    }

}
