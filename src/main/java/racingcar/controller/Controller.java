package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.repository.CarManager;
import racingcar.util.Parser;
import racingcar.domain.Car;
import racingcar.domain.Round;
import racingcar.service.Game;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Controller {
    private final Parser parser = new Parser();
    private final CarManager carManager = new CarManager();
    private Round round;

    public void run(){
        createCars(inputCarNames());
        setRound();
        OutputView.printTitle();
        startGame();
    }
    private void startGame(){
        Game game = new Game(carManager, round);
        game.start();
    }
    private void setRound() {
        round = new Round(inputRacingRound()); //라운드 생성
    }
    private void createCars(List<String> carNames) {
        for (String carName : carNames) {
            carManager.createCar(new Car(carName)); //자동차별 객체 생성
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
