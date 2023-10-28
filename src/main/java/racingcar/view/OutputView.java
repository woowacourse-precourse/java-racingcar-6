package racingcar.view;

import racingcar.domain.Car;

public class OutputView {

    private static final String EXECUTE_RESULT = "실행 결과";
    private static final String WINNER_LIST = "최종 우승자 : ";

    public static void printCurrentDistance(Car car){
        System.out.print(car.getCarName() + " : ");
        int carPosition = car.getCarPosition();
        for(int i = 0;i < carPosition; ++i){
            System.out.print("-");
        }
        System.out.println();
    }
}