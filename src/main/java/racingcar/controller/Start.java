package racingcar.controller;


import java.util.List;
import racingcar.service.AttemptNumber;
import racingcar.service.CarCreator;
import racingcar.service.CarName;
import racingcar.service.Move;
import racingcar.view.OutputView;

public class Start {


    private final CarName carName;
    private final CarCreator carCreator;
    private final AttemptNumber attemptNumber;


    public Start() {
        this.carName = new CarName();
        this.carCreator = new CarCreator();
        this.attemptNumber = new AttemptNumber();
    }


    public void play() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carName.split();
        carName.limitLength();

        List<Car> cars = carCreator.createCars(carName.rangeCarList, 0);
        Move move = new Move(cars);

        attemptNumber.inputNumber();
        int num = attemptNumber.getNum();

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < num; i++) {
            move.allCars();
            OutputView.printCars(cars);
        }
        OutputView.printWinners(cars);

    }


}


