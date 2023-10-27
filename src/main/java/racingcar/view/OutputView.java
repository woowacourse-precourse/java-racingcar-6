package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public static void printResultText(){
        System.out.println("\n실행 결과");
    }

    public static void printResult(List<Car> carList){
        for (Car car : carList) {
            System.out.println(car.getName() +" : "+ car.getScore());
        }
        System.out.println();
    }

    public static void printWinner(List<String> winner){
        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }
}
