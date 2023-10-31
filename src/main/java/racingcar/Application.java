package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Monitor;
import racingcar.domain.Referee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String readLine = readLine();
        List<String> list = Arrays.asList(readLine.split(","));
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            cars.add(new Car(name));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        Integer gameCount = Integer.valueOf(readLine());
        Monitor monitor = new Monitor(cars);

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < gameCount; i++) {
            for (int car = 0; car < cars.size(); car++) {
                Car currentCar = cars.get(car);
                currentCar.move(Randoms.pickNumberInRange(0, 9), currentCar);
            }

            monitor.printCars();
        }

        //

        Referee referee = new Referee(cars);
        System.out.println("최종 우승자 : " + referee.whoIsWinner());

    }
}
