package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;


public class Game {

    public void start() {
        List<Car> cars = this.getCars();
        int count = this.getAttemptCount();
        this.play(cars, count);
        this.result(cars);
    }

    private List<Car> getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분");
        String nameInput = Console.readLine();

        List<String> carNames = stream(nameInput.split(","))
                .toList();

        List<Car> cars = carNames.stream()
                .map(name -> new Car(name))
                .collect(Collectors.toList());
        return cars;
    }

    private int getAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private void play(List<Car> cars, int attemptsCount) {
        this.printBlankLine();
        System.out.println("실행 결과");
        for (int i = 0; i < attemptsCount; i++) {
            cars.forEach(car -> car.run());
            this.printBlankLine();
        }
    }

    private void printBlankLine() {
        System.out.print("\n");
    }

    void result(List<Car> cars) {
        System.out.print("최종 우승자 : ");
        Result result = new Result();
        System.out.println(String.join(", ", result.showWinners(cars)));
    }
}
