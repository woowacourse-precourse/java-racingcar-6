package racingcar.view;

import racingcar.model.domain.Car;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    public static void outputResult(){
        System.out.println(RESULT_MESSAGE);
    }

    public static void outputForward(Car car){
        int forwardCnt = car.getForward();
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < forwardCnt; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

    public static void outputWinner(){
        System.out.print(WINNER_MESSAGE);
    }
}
