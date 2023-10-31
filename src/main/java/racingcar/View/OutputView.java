package racingcar.View;

import racingcar.domain.CarList;

import java.util.List;

public class OutputView {
    private static String Number = "-";
    private static String CAR_NAME = " : ";
    private static String RESULT_MESSAGE = "최종 우승자 : ";
    private static String TRY_RESULT = "\n실행 결과";
    private static String WINNERS = ", ";

    public static void setTryMessage() {
        System.out.println(TRY_RESULT);
    }

    public static void moveForward(CarList carNames, int carCount) {
        System.out.print(carNames.getName() + CAR_NAME);
        for (int j = 0; j < carCount; j++) {
            System.out.print(Number);
        }
        System.out.println();
    }


    public static void result(List<String> winnerList) {
        System.out.print(RESULT_MESSAGE);
        for (int i = 0; i < winnerList.size(); i++) {
            System.out.print(winnerList.get(i));
            if (i < winnerList.size() - 1) {
                System.out.print(WINNERS);
            }
        }
    }
}
