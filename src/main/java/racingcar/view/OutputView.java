package racingcar.view;

import java.util.List;
import racingcar.model.domain.Car;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public static void outputResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void outputForward(Car car) {
        int forwardCnt = car.getForward();
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < forwardCnt; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

    public static void outputWinner(List<String> winners) {
        System.out.print(WINNER_MESSAGE);
        for (int i = 0; i < winners.size(); i++) {
            printComma(winners.get(i), winners.size() - i);
        }
    }

    private static void printComma(String winnerName, int valueForCheck) {
        System.out.print(winnerName);
        if (valueForCheck != 1) {   // winners.size와 index를 뺐을 때 1이면 마지막이므로 ,를 출력하지 않는다.
            System.out.print(", ");
        }
    }
}
