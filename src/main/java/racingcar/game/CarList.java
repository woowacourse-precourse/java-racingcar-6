package racingcar.game;

import java.util.ArrayList;

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

    public void printCarsStatus() {
        for (Car car : this.list) {
            System.out.println(car);
        }
        System.out.println();
    }
}
