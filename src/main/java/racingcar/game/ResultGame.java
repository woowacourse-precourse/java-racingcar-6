package racingcar.game;

import racingcar.Constant;
import racingcar.car.CarInfo;

import java.util.List;
import java.util.stream.Collectors;

public class ResultGame {
    public static void printWinner(List<CarInfo> carList){
        System.out.println(getResultGame(connectWinners(checkWinner(carList))));
    }
    private static List<String> checkWinner(List<CarInfo> carList) {
        int maxMoveCount = getMaxMoveCount(carList);
        return getWinners(carList, maxMoveCount);
    }

    private static int getMaxMoveCount(List<CarInfo> carList) {
        return carList.stream()
                .mapToInt(CarInfo::getMoveCount)
                .max()
                .orElse(0);
    }

    private static List<String> getWinners(List<CarInfo> carList, int maxMoveCount) {
        return carList.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .map(CarInfo::getName)
                .collect(Collectors.toList());
    }

    public static String connectWinners(List<String> winners){
        return String.join(", ", winners);
    }

    public static String getResultGame(String winner){
        return Constant.WINNER_MESSAGE + winner;
    }
}
