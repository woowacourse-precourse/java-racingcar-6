package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static final int CAR_NAME_MAX = 5;
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = Arrays.asList(Console.readLine().split(","));
        ArrayList<Car> cars = new ArrayList<>();

        for (String name: carNames) {
            checkCarNameValid(name);
            cars.add(new Car(name));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int count = 0;
        try {
            count = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }


    }

    /**
     * 자동차 이름의 유효성 검사(5자 이하만 가능함)
     * @param car 자동차 이름
     */
    public static void checkCarNameValid(String name) {
        if (name.length() > CAR_NAME_MAX) {
            throw new IllegalArgumentException();
        }
    }

    static class Car {
        String name;
        int moveCount;

        Car(String name) {
            this.name = name;
            this.moveCount = 0;
        }
    }
}
