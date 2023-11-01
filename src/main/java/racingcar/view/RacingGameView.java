package racingcar.view;

import racingcar.model.Car;
import racingcar.model.CarList;

import java.util.stream.Collectors;

public class RacingGameView {

    private final String moving = "-";

    public void printInputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printInputTryCount(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printGameResult(){
        System.out.println("실행 결과");
    }

    public void printMoveDist(CarList carList){
        carList.getCarList()
                .forEach(car -> System.out.println(car.getCarName() + " : " + moving.repeat(car.getMoveCnt())));
        System.out.println();
    }

    public void printWinners(CarList carList){
        System.out.print("최종 우승자 : ");
        String winners = carList.findWinners().stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
        System.out.println(winners);
    }
}
