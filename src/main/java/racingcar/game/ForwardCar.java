package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Constant;
import racingcar.car.CarInfo;

import java.util.List;

public class ForwardCar {
    private static int randomNumber(){
        return Randoms.pickNumberInRange(Constant.MIN_VALUE,Constant.MAX_VALUE);
    }

    private static boolean isForward(int number){
        return number >= Constant.FORWARD_CONDITION;
    }

    private static void forwardCar(List<CarInfo> carList) {
        for (CarInfo car : carList) {
            if (isForward(randomNumber())) {
                car.setMoveCount(car.getMoveCount() + 1);
            }
        }
        result(carList);
    }

    private static void result(List<CarInfo> carList){
        for (CarInfo car : carList) {
            System.out.println(car.getName() + " : " + createMoveCount(car.getMoveCount()));
        }
        System.out.println();
    }

    private static String createMoveCount(int moveCount) {
        if (moveCount <= 0) {
            return "";
        }
        return "-".repeat(moveCount);
    }

    public static void playGame(List<CarInfo> carList, int gameRound) {
        System.out.println();
        System.out.println("실행 결과");
        for (int round = 0; round < gameRound; round++) {
            forwardCar(carList);
        }
    }
}
