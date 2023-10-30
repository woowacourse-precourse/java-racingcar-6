package racingcar.view;

import java.util.List;
import java.util.stream.IntStream;

public class OutputView {
    private final static String RESULT = "실행 결과";
    private final static String COLON = " : ";

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

    private String driveCountToString(int driveCount) {
        return "-".repeat(driveCount);
    }
}
