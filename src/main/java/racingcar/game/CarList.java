package racingcar.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Car 클래스를 모아두는 컬렉션
 *
 * @author gemstoneyang
 */
public class CarList {
    private final ArrayList<Car> list;

    /**
     * @param commaSeparatedNames ,로 구분된 이름 문자열
     */
    public CarList(String commaSeparatedNames) {
        this.list = new ArrayList<>();

        for (String name : parseInput(commaSeparatedNames)) {
            this.list.add(new Car(name));
        }
    }

    private String[] parseInput(String commaSeparatedNames) {
        return commaSeparatedNames.split(",");
    }

    /**
     * 전체 자동차의 움직임을 시도하고 결과를 출력
     */
    public void tryAllCars() {
        for (Car car : this.list) {
            car.tryMove();
        }
    }

    /**
     * 전체 자동차의 상태를 출력
     */
    public void printCarsStatus() {
        for (Car car : this.list) {
            System.out.println(car);
        }
        System.out.println();
    }

    /**
     * 가장 먼 거리에 있는 자동차들의 이름을 반환
     * <p>
     * 각 이름들은 ,로 구분되어 있음
     *
     * @return 자동차들의 이름
     */
    public String getLongestDistanceNames() {
        int maxScore = getMaxScore();

        List<String> highScoreCarNames = list.stream()
                .filter(car -> car.getDistance() == maxScore)
                .map(Car::getName)
                .collect(Collectors.toList());

        return String.join(", ", highScoreCarNames);
    }

    private int getMaxScore() {
        return list.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }
}
