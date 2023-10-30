package racingcar.view;

import java.util.List;
import java.util.stream.IntStream;

public class OutputView {
    private final static String RESULT = "실행 결과";
    private final static String COLON = " : ";
    private final static String WINNER = "최종 우승자";

    public void printResult() {
        System.out.println(RESULT);
    }

    public void printDrive(List<String> carNameList, List<Integer> carDriveCountList) {
        int carListSize = carNameList.size();
        String carName;
        int carDriveCount;
        String driveCountVisual;

        for (int i = 0; i < carListSize; i++) {
            carName = carNameList.get(i);
            carDriveCount = carDriveCountList.get(i);
            driveCountVisual = driveCountToString(carDriveCount);

            System.out.println(carName + COLON + driveCountVisual);

        }
    }

    public void printOneWinner(String winnerName) {
        System.out.println(WINNER + COLON + winnerName);
    }

    private String driveCountToString(int driveCount) {
        return "-".repeat(driveCount);
    }
}
