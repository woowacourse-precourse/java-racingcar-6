package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceManager {
    private final RaceOfficial raceOfficial = new RaceOfficial();

    private List<Car> cars = new ArrayList<>();
    private int tryNumber;

    public void run() {
        init();
        start();

        List<Car> winners = raceOfficial.findWinners(cars);
        showWinners(winners);
    }

    public void init() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNameSplit = inputCarNames().split(",");
        for (String name : carNameSplit) {
            cars.add(new Car(name));
        }

        System.out.println("시도할 횟수는 몇회인가요?");
        tryNumber = inputTryNumber();
    }

    public String inputCarNames() {
        return Console.readLine();
    }

    public int inputTryNumber() {
        return Integer.parseInt(Console.readLine());
    }

    public void start() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryNumber; i++) {
            cars.stream().forEach(car -> {
                car.tryToMove();
                System.out.println(car);
            });
            System.out.println();
        }
    }

    public void showWinners(List<Car> winners) {
        List<String> names = winners.stream().map(Car::getName).collect(Collectors.toList());

        String allWinners = String.join(", ", names);
        System.out.println("최종 우승자 : " + allWinners);
    }
}
