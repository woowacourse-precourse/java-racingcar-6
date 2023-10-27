package racingcar;

import racingcar.model.Car;
import java.util.ArrayList;
import java.util.List;

import static racingcar.FindWin.findWinCars;
import static racingcar.Input.inputCarName;
import static racingcar.Input.inputNum;
import static racingcar.Play.findEachCarRandomNum;
import static racingcar.Print.printEachRotate;
import static racingcar.Print.printResult;

public class Application {
    public static List<Car> cars;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        cars = new ArrayList<>();
        for (String name : inputCarName()) {
            cars.add(new Car(name, 0));
        }

        int carLength = cars.size();
        System.out.println("시도할 회수는 몇회인가요?");
        int num =  inputNum();
        System.out.println();

        System.out.println("실행 결과");
        for (int i=0; i<num; i++) {
            for (int index : findEachCarRandomNum(carLength)) {
                int pre = cars.get(index).length;
                cars.get(index).setLength(pre+1);
            }
            System.out.println(printEachRotate(cars));
        }

        List<String> winCarsName = findWinCars(cars);
        String answer = printResult(winCarsName);
        System.out.println(answer);

    }
}
