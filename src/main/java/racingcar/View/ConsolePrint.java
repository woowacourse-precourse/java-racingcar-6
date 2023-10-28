package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.Model.Car;

public class ConsolePrint {

    public static String readCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static String readTryNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    public static void printRace(List<Car> carList) {
        System.out.println("\n실행 결과");
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            printDistance(car);
            System.out.println();
        }
    }

    public static void printDistance(Car car) {
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print("-");
        }
    }

}
