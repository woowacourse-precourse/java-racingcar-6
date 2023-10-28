package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
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

    public static void printOpening() {
        System.out.println("\n실행 결과");
    }

    public static void printRace(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            printDistance(car);
        }
        System.out.println();
    }

    public static void printDistance(Car car) {
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinner(List<Car> carList) {
        int maxDistance = carList.get(0).getDistance();

//        To check if there are multiple winners
        List<String> winners = carList.stream()
                .takeWhile(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());

        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }

}
