package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.input.CarNamesInputReader;
import racingcar.input.NumberOfMovementInputReader;
import racingcar.racingcar.Car;
import racingcar.racingcar.RacingCar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        CarNamesInputReader carNamesInputReader = new CarNamesInputReader();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<Car> carList = Stream.of(carNamesInputReader.readLine()
                        .split(",", -1))
                .map(e -> new Car(e, 0))
                .collect(Collectors.toList());


        NumberOfMovementInputReader number = new NumberOfMovementInputReader();

        System.out.println("시도할 회수는 몇회인가요?");

        RacingCar racingCar = new RacingCar(carList, Integer.parseInt(number.readLine()));

        System.out.println("실행 결과");

    }
}
