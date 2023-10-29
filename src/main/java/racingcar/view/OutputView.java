package racingcar.view;

import racingcar.domain.Car;

public class OutputView {

    private static final OutputView INSTANCE = new OutputView();

    private OutputView() {}

    public OutputView getInstance(){
        return INSTANCE;
    }

    public void printPlayResultMessage(){
        System.out.println("실행 결과");
    }

    public void printCarName(Car car){
        System.out.print(car.getCarName() + " : ");
    }
}
