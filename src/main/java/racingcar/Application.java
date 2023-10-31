package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.CarGenerator;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Referee;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //input
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] input = Console.readLine().split(",");
        CarGenerator cars = new CarGenerator(input);
        System.out.println("시도할 회수는 몇회인가요?");
        Integer count = 0;
        try {
            count = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요. 예외 강제 발생.");
        }

        //run
        System.out.println("\n실행 결과");
        for (int t = 0; t < count; t++) {
            Integer[] randomNumbers = NumberGenerator.createRandomNumbers(cars.getNames().length);
            racing(cars, randomNumbers);
            for (int i = 0; i < cars.getNames().length; i++) {
                System.out.println(cars.getNames()[i] + " : " + cars.getLocations()[i]);
            }
            System.out.println();
        }

        //winner
        List<String> result = Referee.calculateCars(cars);
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i != result.size() - 1) {
                System.out.print(", ");
            }
        }
    }

    public static void racing(CarGenerator cars, Integer[] randomNumbers) {
        // 자동차 위치 update
        for (int i = 0; i < cars.getNames().length; i++) {
            if (randomNumbers[i] >= 4) {
                cars.getLocations()[i] += "-";
            }
        }
    }
}
