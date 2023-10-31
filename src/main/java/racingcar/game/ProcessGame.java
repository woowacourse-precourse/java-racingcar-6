package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Constant;
import racingcar.car.CarInfo;

import java.util.List;

public class ProcessGame {
    public static void playGame(List<CarInfo> carList, int gameRound) {
        System.out.println();
        System.out.println(Constant.RESULT_MESSAGE);
        for (int round = 0; round < gameRound; round++) {
            playRound(carList);
        }
    }

    private static void playRound(List<CarInfo> carList) {
        forwardCar(carList);
        printResult(carList);
    }

    private static int randomNumber(){
        return Randoms.pickNumberInRange(Constant.MIN_VALUE,Constant.MAX_VALUE);
    }

    private static boolean isForward(int number){
        return number >= Constant.FORWARD_CONDITION;
    }

    private static void forwardCar(List<CarInfo> carList) {
        for (CarInfo car : carList) {
            if (isForward(randomNumber())) {
                car.setMoveCount(car.getMoveCount() + Constant.FORWARD_VALUE);
            }
        }
    }

    private static void printResult(List<CarInfo> carList){
        for (CarInfo car : carList) {
            System.out.println(formatResult(car));
        }
        System.out.println();
    }

    private static String formatResult(CarInfo car){
        return String.format("%s : %s",
                car.getName(),
                createMoveCountDisplay(car.getMoveCount()));
    }

    private static String createMoveCountDisplay(int moveCount) {
        if (moveCount <= 0) {
            return "";
        }
        return "-".repeat(moveCount);
    }
}
