package racingcar;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Racing;

public class Application {
    public static void main(String[] args) {
        List<Car> cars;
        int iterNum;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carInput = readLine();
        cars = stringToCar(carInput);
        System.out.println("시도할 회수는 몇회인가요?");
        String iterInput = readLine();
        try {
            iterNum = Integer.parseInt(iterInput);
        }
        catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }

        Racing racing = new Racing(cars, iterNum, 4);
        racing.run();
    }

    private static List<Car> stringToCar(String carInput) {
        List<Car> cars = new ArrayList<>();
        String[] nameArray = carInput.split(",");
        for (String name : nameArray) {
            if (name.length() > 5)
                throw new IllegalArgumentException();
            else {
                Car car = new Car(name);
                cars.add(car);
            }
        }
        return cars;
    }
}
