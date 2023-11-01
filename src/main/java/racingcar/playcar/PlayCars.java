package racingcar.playcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class PlayCars {

    private final Scanner scanner;
    private List<String> cars;
    private Map<String, Integer> carToDistance;
    private int numberOfTry;
    private List<String> winners;

    public PlayCars(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> getCars() {
        return cars;
    }

    public int getNumberOfTry() {
        return numberOfTry;
    }

    public void input() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        this.cars = Arrays.asList(scanner.next().split(","));
        System.out.println("시도할 회수는 몇회인가요?");
        this.numberOfTry = scanner.nextInt();
        System.out.println();

        this.carToDistance = this.cars.stream().collect(Collectors.toMap(car -> car, car -> 0));
    }

    public void eachTry() {
        for (String car : cars) {
            if (runOrStop()) {
                carToDistance.put(car, carToDistance.get(car) + 1);
            }
        }
    }

    private boolean runOrStop() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public void getResult() {
        System.out.println("실행 결과");
        eachCurrent();
    }

    private void eachCurrent() {
        for (String car : cars) {
            System.out.printf("%s : %s%n", car, "-".repeat(carToDistance.get(car)));
        }
        System.out.println();
    }

    public void getWinner() {
        int maxOfDistance = carToDistance.values().stream().mapToInt(i -> i).max().orElseThrow(() -> new IllegalArgumentException("문제가 발생했습니다."));

        for (String car : cars) {
            if (carToDistance.get(car) == maxOfDistance) {
                this.winners.add(car);
            }
        }
        System.out.printf("최종 우승자 : %s", String.join(", ", winners));

    }
}
