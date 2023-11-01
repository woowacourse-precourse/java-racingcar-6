package racingcar.playcar;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class PlayCars {

    private final List<String> winners = new ArrayList<>();
    private List<String> cars;
    private Map<String, Integer> carToDistance;
    private int numberOfTry;

    public void input() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            this.cars = Arrays.asList(readLine().split(","));
        } catch (Exception e) {
            throw new IllegalArgumentException("경주할 자동차 목록 입력에 문제가 있습니다.");
        }

        if (ContainNotCharacter()) {
            throw new IllegalArgumentException("경주할 자동차 목록 입력에 문제가 있습니다.");
        }

        try {
            System.out.println("시도할 회수는 몇회인가요?");
            this.numberOfTry = Integer.parseInt(readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("시도할 회수 입력에 문제가 있습니다.");
        }
        System.out.println();

        this.carToDistance = this.cars.stream().collect(Collectors.toMap(car -> car, car -> 0));
    }

    public void getResult() {
        System.out.println("실행 결과");
        for (int i = 0; i < numberOfTry; i++) {
            eachCurrent();
        }
    }

    public void eachTry() {
        for (String car : cars) {
            if (runOrStop()) {
                carToDistance.put(car, carToDistance.get(car) + 1);
            }
        }
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

    private boolean runOrStop() {
        return pickNumberInRange(0, 9) >= 4;
    }

    private void eachCurrent() {
        eachTry();

        for (String car : cars) {
            System.out.printf("%s : %s%n", car, "-".repeat(carToDistance.get(car)));
        }
        System.out.println();
    }

    private boolean ContainNotCharacter() {
        boolean result = false;

        for (String car : cars) {
            if (result) {
                return true;
            }
            result = car.matches("[^a-zA-Z]+");
        }
        return result;
    }
}
