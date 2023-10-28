package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingLogic {
    static void repeatRaceAsTryTimes(List<Car> carList, int tryTimes) {
        int repeatTimes = 0;
        while (repeatTimes < tryTimes) {
            List<Integer> randomNumberList = decideGoOrStopByRandoms(carList.size());
            List<Boolean> goOrStopList = isGreaterThanOrEqualToFour(randomNumberList);
            saveRaceData(carList, goOrStopList);
            InputAndOutput.outputRaceResult(carList);
            repeatTimes++;
        }
        List<Integer> winnerList = checkWinner(carList);
        saveWinnerData(carList, winnerList);
        InputAndOutput.outputRaceWinner(carList);
    }

    static List<Integer> decideGoOrStopByRandoms(int carListSize) {
        List<Integer> randomNumberList = new ArrayList<>();
        for (int i = 0; i < carListSize; i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            randomNumberList.add(randomNumber);
        }
        return randomNumberList;
    }

    static List<Boolean> isGreaterThanOrEqualToFour(List<Integer> randomNumberList) {
        List<Boolean> goOrStopList = new ArrayList<>();
        for (int randomNumber : randomNumberList) {
            if (randomNumber >= 4) {
                goOrStopList.add(true);
            } else {
                goOrStopList.add(false);
            }
        }
        return goOrStopList;
    }

    static void saveRaceData(List<Car> carList, List<Boolean> goOrStopList) {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            if (goOrStopList.get(i)) {
                int newTotalGoTimes = car.getTotalGoTimes() + 1;
                car.setTotalGoTimes(newTotalGoTimes);
                List<String> newGoOrStopRecord = car.getGoOrStopRecord();
                newGoOrStopRecord.add("-");
                car.setGoOrStopRecord(newGoOrStopRecord);
            }
        }
    }

    static List<Integer> checkWinner(List<Car> carList) {
        List<Integer> winnerList = new ArrayList<>();
        int maxGoTimes = 0;
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            if (car.getTotalGoTimes() > maxGoTimes) {
                winnerList.clear();
                winnerList.add(i);
            } else if (car.getTotalGoTimes() == maxGoTimes) {
                winnerList.add(i);
            }
        }
        return winnerList;
    }

    static void saveWinnerData(List<Car> carList, List<Integer> winnerList) {
        for (int index : winnerList) {
            Car car = carList.get(index);
            car.setWinner(true);
        }
    }
}
