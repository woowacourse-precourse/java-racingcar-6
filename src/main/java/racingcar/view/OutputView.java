package racingcar.view;

import java.util.List;
import racingcar.dto.output.CarInfo;
import racingcar.dto.output.WinnerInfo;

public class OutputView {
    private static boolean isFirstTime = true;

    public static void printRoundResult(List<CarInfo> carInfos) {
        if (isFirstTime) {
            System.out.println("\n실행 결과");
            isFirstTime = false;
        }

        for (CarInfo carInfo : carInfos) {
            System.out.println(carInfo);
        }
        System.out.println();
    }

    public static void printWinner(WinnerInfo winnerInfo) {
        List<String> names = winnerInfo.names();
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(",", names));
    }
}
