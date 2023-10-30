package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

import static racingcar.controller.FindWin.findWinCars;
import static racingcar.controller.Input.inputCarName;
import static racingcar.controller.Input.inputNum;
import static racingcar.view.Message.inputNameMessage;
import static racingcar.view.Message.inputNumMessage;
import static racingcar.view.Print.printEachRotate;
import static racingcar.view.Print.printResult;


public class Play {
    private static List<Car> cars;
    private static int num;
    public static void start() {
        inputNameMessage();
        List<String> names = inputCarName();
        List<Car> cars = new ArrayList<>();
        for (String name : inputCarName()) {
            cars.add(new Car(name, 0));
        }

        inputNumMessage();
        num = inputNum();
        System.out.println();

        System.out.println("실행 결과");
        rotate(num);

        result();
    }

    public static void rotate(int num) {
        int carLength = cars.size();
        for (int i=0; i<num; i++) {
            for (int index : findEachCarRandomNum(carLength)) {
                int pre = cars.get(index).length;
                cars.get(index).addLength(pre+1);
            }
            System.out.println(printEachRotate(cars));
        }
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

    public static int makeRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static boolean checkIFGoOrStop(int num) {
        if (num < 4) {
            return false;
        }
        return true;
    }

    public static void result() {
        List<String> winCarsName = findWinCars(cars);
        String answer = printResult(winCarsName);
        System.out.println(answer);
    }



}
