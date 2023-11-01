package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarGame {
    List<Car> racingCars;
    int moveCount;

    public RacingCarGame() {
        this.racingCars = makeCars();
        this.moveCount = readMoveCount();
    }

    private List<Car> makeCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<Car> cars = new ArrayList<>();

        List<String> names = readCarNames();
        names.forEach(name -> cars.add(new Car(name.trim())));

        return cars;
    }

    // 기능 1) 5자 이하의 자동차 이름 n개를 쉼표(,)를 기준으로 구분하여 입력 받는다.
    private List<String> readCarNames() {
        return Arrays.stream(Console.readLine().split(",")).toList();
    }

    // 기능 2) 몇 번의 이동을 할 것인지 입력 받는다.
    private int readMoveCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    // 기능 3) 0에서 9 사이의 무작위 값을 구한 후, 그 값이 4 이상인 경우에는 자동차가 전진하고 그렇지 않으면 멈춘다.
    private void moveOrStop(Car car) {
        int randomNumber = makeRandomNumber();

        if(randomNumber >= 4) {
            car.move();
        }

        writeCarTrace(car);
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void writeCarTrace(Car car) {
        String trace = IntStream.range(0, car.getDistance()).mapToObj(i -> "-").collect(Collectors.joining());
        System.out.println(car.getName() + " : " + trace);
    }

    // 기능 4) 사용자가 입력한 이동 횟수만큼 각 자동차의 이름과 이동 결과를 출력한다.
    private void writeEachMove() {
        System.out.println();
        System.out.println("실행 결과");

        IntStream.range(0, this.moveCount).forEach(i -> {
            this.racingCars.forEach(this::moveOrStop);
            System.out.println();
        });
    }
}
