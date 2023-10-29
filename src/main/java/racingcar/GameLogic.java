package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GameLogic {
    public static boolean decideMove() {
        int num = getRandomNumber();
        if (9 >= num && num >= 4) {
            return true;
        } else if (3 >= num && num >= 0) {
            return false;
        } else {
            throw new IllegalArgumentException("랜덤 값 오류");
        }
    }

    public static int getRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    public static int findMaxMove(Car[] carList){
        int max = 0;
        for (Car car : carList){
            max = Math.max(car.getCnt(), max);
        }
        return max;
    }

    public static String findWinner(Car[] carList, int finalMax){
        return Arrays.stream(carList)
                .filter(car -> car.isMax(finalMax))
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
