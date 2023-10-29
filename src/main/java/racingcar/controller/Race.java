package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.MoveCnt;
import racingcar.model.CarMove;
import racingcar.model.CarName;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Race {
    private InputView inputView;
    private OutputView outputView;
    private CarName carName;
    private CarMove carMove;
    private List<Car> cars;
    private MoveCnt moveCnt;

    public Race() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.carName = new CarName();
    }

    public void run() {
        start();
        move();
        printWinner();
    }

    public void start() {
        inputView.requestCarName(); // 자동차 이름 요청 구문 출력
        cars = carName.splitUserInputCarName(Console.readLine()); // 유저 입력문 쉼표로 구분해서 Car 리스트에 저장

        inputView.requestMoveCnt(); // 시도할 횟수 요청 구문 출력
        moveCnt = new MoveCnt(Console.readLine());
    }

    public void move() {


    }

    public void printWinner() {

    }


}
