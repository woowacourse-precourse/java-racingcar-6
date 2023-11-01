package racingcar;

import java.util.List;

public class OutputView {

    public OutputView() {
    }

    public void printRacingCarGameResult(List<String> carNameList, List<Integer> carMovingCountList) {
        for (int i = 0; i < carNameList.size(); i++) {
            String carName = carNameList.get(i);

            int carMovingCount = carMovingCountList.get(i);
            String carMovingCountString = changeCarMovingCountToString(carMovingCount);

            System.out.println(carName + " : " + carMovingCountString);
        }
    }

    public String changeCarMovingCountToString(int carMovingCount) {
        String carMovingCountString = "";

        for (int i = 0; i < carMovingCount; i++) {
            carMovingCountString += "-";
        }
        return carMovingCountString;
    }
}
