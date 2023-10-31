package racingcar.controller;


import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.service.AttemptNumber;
import racingcar.service.CarCreator;
import racingcar.service.CarName;
import racingcar.service.Move;
import racingcar.service.RandomNumber;
import racingcar.view.OutputView;

public class Start {

    private Move move;
    private CarName carName;
    private CarCreator carCreator;
    private OutputView outputView;
    private AttemptNumber attemptNumber;


    public Start(Move move, CarName carName, CarCreator carCreator,
            OutputView outputView, AttemptNumber attemptNumber) {
        this.move = move;
        this.carName = carName;
        this.carCreator = carCreator;
        this.outputView = outputView;
        this.attemptNumber = attemptNumber;
    }


    public void Game() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carName.split();
        carName.range();

        List<Car> cars = carCreator.createCars(carName.rangeCarList, 0);
        Move move = new Move(cars);
        move.AllCars();

        attemptNumber.inputNumber();
        int num = attemptNumber.getNum();

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < num; i++) {
            move.AllCars();
            OutputView.printCars(cars);
        }
        OutputView.printWinners(cars);

    }


}


