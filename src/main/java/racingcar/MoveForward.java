package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class MoveForward {

    static void totalGame(Car[] carArr, int n) {
        System.out.println("실행 결과");
        int i = 0;
        while (i < n) {
            moveCars(carArr);
            printCars(carArr);
            System.out.println("");
            i++;
        }
    }

    static List<Boolean> moveCars(Car[] carArr) {
        List<Boolean> moveArr = new ArrayList<Boolean>();
        boolean isMove;
        for (Car car: carArr) {
            isMove = getRandomNumber();
            if (isMove) {
                car.score += 1;
            }
            moveArr.add(isMove);
        }
        return moveArr;
    }

    static void printCars(Car[] carArr) {
        for (Car car: carArr) {
            String tempScore = "-".repeat(car.score);
            System.out.printf("%s : %s \n", car.name, tempScore);
        }
    }

    static boolean getRandomNumber() {
        int num = Randoms.pickNumberInRange(0, 9);
        if (num >= 4) {
            return true;
        } else {
            return false;
        }
    }
}
