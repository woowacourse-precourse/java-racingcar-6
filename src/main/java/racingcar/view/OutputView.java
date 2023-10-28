package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    private static final String EXECUTE_RESULT = "실행 결과";
    private static final String WINNER_LIST = "최종 우승자 : ";

    public static void printResult(List<Car> carList){
        System.out.println(EXECUTE_RESULT);
        for (Car car : carList) {
            printCurrentDistance(car);
        }
        System.out.println();
    }

    public static void printCurrentDistance(Car car){
        System.out.print(car.getCarName() + " : ");
        int carPosition = car.getCarPosition();
        for(int i = 0;i < carPosition; ++i){
            System.out.print("-");
        }
        System.out.println();
    }

}