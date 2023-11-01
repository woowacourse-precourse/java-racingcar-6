package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static final int CAR_NAME_MAX = 5;
    private static final int MOVING_FORWARD = 4;

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = Arrays.asList(Console.readLine().split(","));
        ArrayList<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            checkCarNameValid(name);
            cars.add(new Car(name));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int count;
        try {
            count = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        System.out.println("\n실행 결과");

        while (count > 0) {
            count--;
            moveCars(cars);
            printUnitResult(cars);
            System.out.println();
        }

    }

    /**
     * 자동차 이름의 유효성 검사(5자 이하만 가능함)
     *
     * @param name 자동차 이름
     */
    public static void checkCarNameValid(String name) {
        if (name.length() > CAR_NAME_MAX) {
            throw new IllegalArgumentException();
        }
    }

    public static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move();
        }
    }

    public static void printUnitResult(List<Car> cars) {
        for (Car car : cars) {
            StringBuilder sb = new StringBuilder();
            sb.append(car.name).append(" : ");
            addDash(sb, car.moveCount);
            System.out.println(sb);
        }
    }

    public static void addDash(StringBuilder sb, int count) {
        while (count > 0) {
            count--;
            sb.append("-");
        }
    }

    static class Car {
        String name;
        int moveCount;

        Car(String name) {
            this.name = name;
            this.moveCount = 0;
        }

        public void move() {
            if (Randoms.pickNumberInRange(0, 9) >= MOVING_FORWARD) {
                this.moveCount++;
            }
        }
    }
}
