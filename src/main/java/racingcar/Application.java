package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import racingcar.domain.NumberGenerator;
import racingcar.domain.Referee;
import racingcar.domain.Trial;

public class Application {
    public static void main(String[] args) {
//        NumberGenerator generator = new NumberGenerator();
//        int number = generator.createRandomNumber();
//        System.out.println(number);

//        boolean moving1 = Referee.checkMoveForward();
//        boolean moving2 = Referee.checkMoveForward();
//        System.out.println(moving1);
//        System.out.println(moving2);

        List<String> Cars = askCars();
//        for (String car: Cars) {
//            System.out.println(car);
//        }

        HashMap<String, Integer> distanceOfCars = getInitialDistances(Cars);
        for (String key: distanceOfCars.keySet()) {
            Integer value = distanceOfCars.get(key);
            System.out.println("Key:" + key + ", Value:" + value);
        }
        Trial trial = new Trial();
        for (int j = 0; j < 5; j++) {
            distanceOfCars = trial.moveForward(distanceOfCars);
        }
        for (String key: distanceOfCars.keySet()) {
            Integer value = distanceOfCars.get(key);
            System.out.println("Key:" + key + ", Value:" + value);
        }
    }

    public static List<String> askCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] inputArray = input.split(",");

        List<String> Cars = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            String car = inputArray[i];
            if (car.length() > 5) {
                throw new IllegalArgumentException("유효하지 않은 입력입니다.");
            }
            Cars.add(inputArray[i]);
        }
        return Cars;
    }

    public static HashMap<String, Integer> getInitialDistances(List<String> Cars) {
        HashMap<String, Integer> distanceOfCars = new HashMap<String, Integer>();

        for (String car: Cars) {
            distanceOfCars.put(car, 0);
        }
        return distanceOfCars;
    }
}
