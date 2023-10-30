package racingcar.view;

import racingcar.domain.Car;

public class OutputView {

    public void printForEach(Car car){
        System.out.println(car.getName()+" : "+car.located());
    }

    public void printWinner(String winners){
        System.out.println("최종 우승자 : "+winners);
    }
}
