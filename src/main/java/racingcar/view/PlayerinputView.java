package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class PlayerinputView {
    public static String[] getNames() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) ");
        String inputcarname = Console.readLine();
        String[] names = inputcarname.split(",");
        if (names.length < 2) {
            throw new IllegalArgumentException("최소 2개 이상의 자동차 이름을 입력하세요.");
        }
        for (String name : names) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름을 입력하세요.");
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i]); // 자동차이름 입력값 사용자 확인 출력
            if (i < names.length - 1) {
                System.out.print(",");
            }
        }
        return names;
    }

    public static List<Car> saveNames(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name, 0));
        }
        return cars;
    }

    public static int getRound() {
        System.out.print("\n시도할 회수는 몇회인가요? ");
        String inputround = Console.readLine();
        if (inputround.trim().isEmpty()) {
            throw new IllegalArgumentException("시도할 횟수를 입력하세요.");}
        int round;
        try {
            round = Integer.parseInt(inputround);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("0 이상의 숫자를 입력하세요.");
        }
        if (round < 0) {
            throw new IllegalArgumentException("시도할 횟수는 0 이상이어야 합니다.");
        }
        return round;
    }

}
