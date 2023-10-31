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
        cars = new ArrayList<>();
        saveCar();

        inputNumMessage();
        num = inputNum();
        System.out.println();

        System.out.println("실행 결과");
        rotate(num);

        result();
    }

    public static void saveCar() {
        for (String name : inputCarName()) {
            cars.add(new Car(name, 0));
        }
    }

    public static void rotate(int num) {
        for (int i=0; i<num; i++) {
            addLengthIfGo();
            printEachRotate(cars);
        }
    }

    public static void addLengthIfGo() {
        int carLength = cars.size();
        int addLength = 1;
        for (int index : findEachCarRandomNum(carLength)) {
            int pre = cars.get(index).length;
            cars.get(index).addLength(pre+addLength);
        }
    }

    public static List<Integer> findEachCarRandomNum(int carListSize) {
        List<Integer> goCarsIndex = new ArrayList<>();
        for (int index=0; index<carListSize; index++) {
            int tmpRandNum = makeRandomNum();
            if(checkGoOrStop(tmpRandNum)) {
                goCarsIndex.add(index);
            }
        }
        return goCarsIndex;
    }

    public static int makeRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static boolean checkGoOrStop(int num) {
        int standardGoNum = 4;
        if (num < standardGoNum) {
            return false;
        }
        return true;
    }

    public static void result() {
        List<String> winCarsName = findWinCars(cars);
        printResult(winCarsName);
    }

}
