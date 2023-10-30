package racingcar.view;

import racingcar.domain.Car;

public class OutputView {

    public void printForEach(Car car,String current){
        System.out.println(car.getName()+" : "+current);
    }

    public void printWinner(String winners){
        System.out.println("최종 우승자 : "+winners);
    }
}
