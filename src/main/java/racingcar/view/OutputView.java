package racingcar.view;

import java.util.List;

public class OutputView {
    private final static String RESULT = "실행 결과";
    private final static String COLON = " : ";
    private final static String WINNER = "최종 우승자";

    public void printResult() {
        System.out.println();
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

        System.out.println();
    }

    public void printOneWinner(String winnerName) {
        System.out.println(WINNER + COLON + winnerName);
    }

    public void printWinners(List<String> winnerNameList) {
        String winnerNames = winnerNameListToString(winnerNameList);
        System.out.println(WINNER + COLON + winnerNames);
    }

    private String winnerNameListToString(List<String> winnerNameList) {
        return String.join(", ", winnerNameList);
    }

    private String driveCountToString(int driveCount) {
        return "-".repeat(driveCount);
    }
}
