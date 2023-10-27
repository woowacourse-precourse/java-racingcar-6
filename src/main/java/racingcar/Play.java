package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static racingcar.FindWin.findWinCars;
import static racingcar.Input.inputCarName;
import static racingcar.Input.inputNum;
import static racingcar.Message.inputNameMessage;
import static racingcar.Message.inputNumMessage;
import static racingcar.Print.printEachRotate;
import static racingcar.Print.printResult;


public class Play {
    public static List<Car> cars;
    public static void start() {
        inputNameMessage();
        cars = new ArrayList<>();
        for (String name : inputCarName()) {
            cars.add(new Car(name, 0));
        }

        int carLength = cars.size();

        inputNumMessage();
        int num =  inputNum();
        System.out.println();

        System.out.println("실행 결과");
        for (int i=0; i<num; i++) {
            for (int index : findEachCarRandomNum(carLength)) {
                int pre = cars.get(index).length;
                cars.get(index).addLength(pre+1);
            }
            System.out.println(printEachRotate(cars));
        }

        List<String> winCarsName = findWinCars(cars);
        String answer = printResult(winCarsName);
        System.out.println(answer);


    }
    public static int makeRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static boolean checkIFGoOrStop(int num) {
        //System.out.println(num);
        if (num < 4) {
            return false;
        }
        return true;
    }

    public static List<Integer> findEachCarRandomNum(int carLength) {
        List<Integer> randomNum = new ArrayList<>();

        for (int index=0; index<carLength; index++) {
            int tmpRandNum = makeRandomNum();
            if(checkIFGoOrStop(tmpRandNum)) {
                randomNum.add(index);
            }
        }
        return randomNum;
    }

}
