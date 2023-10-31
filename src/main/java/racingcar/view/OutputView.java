package racingcar.view;

import racingcar.Car;

public class OutputView {

    public static void roundResult(Car car){
        System.out.println(car.toString());
    }

    public static void roundFinish(){
        System.out.println();
    }

    public static void finalWinner(String winner){
        System.out.println("최종 우승자 : " + winner);
    }
}
