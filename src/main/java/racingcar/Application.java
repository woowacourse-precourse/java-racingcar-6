package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.RandomNumber;
import racingcar.domain.Result;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Car car = new Car();
        RandomNumber number = new RandomNumber();
        Result result = new Result();
        List<String> cars = new ArrayList<>();
        List<Integer> randomNumbers = new ArrayList<>();
        List<Integer> raceNumber = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String raceCars = Console.readLine();
        cars = car.name(raceCars);

        System.out.println("시도할 회수는 몇회인가요?");
        int move = Integer.parseInt(Console.readLine());
        System.out.println(" ");
        System.out.println("실행결과");
        for(int i = 0; i < move; i++){
            randomNumbers = number.random(cars.size());
            raceNumber = number.compare(randomNumbers);
            result.racePrint(cars, raceNumber);
            System.out.println(" ");
        }
    }
}
