package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.InputView;
import racingcar.view.outputView;
import racingcar.repository.CarAdmin;
import racingcar.util.Parser;
import racingcar.domain.Car;

import java.util.List;
import java.util.ArrayList;

public class Controller {
    private final Parser parser = new Parser();
    private final CarAdmin carAdmin = new CarAdmin();

    public void testRun(){
        createCars(inputCarNames()); //자동차 생성

        //outputView.printRacingResult(inputCarNames(), inputRacingRound());
    }

    private void createCars(List<String> carNames) {
        for (String carName : carNames) {
            carAdmin.createCar(new Car(carName)); //자동차별 객체 생성
        }
    }
    private List<String> inputCarNames(){
        InputView.requestCarNaming(); //요청문구 출력
        return parser.getSplitString(Console.readLine()); //리스트화 및 예외처리
    }
    private int inputRacingRound(){
        InputView.requestRacingRoundNumber(); //요청문구 출력
        return parser.changeStringToInteger(Console.readLine()); //타입변환 및 예외처리
    }
}
