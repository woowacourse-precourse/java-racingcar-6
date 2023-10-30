package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static List<String> getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] tempCars = Console.readLine().split(",");
        // 예외 처리
        // 이름 5자 이하
        List<String> cars = new ArrayList<>();
        for (int i = 0; i < tempCars.length; i++) {
            if (tempCars[i].length() > 5)
                throw new IllegalArgumentException("이름은 5자 이하로 작성하세요.");
            cars.add(tempCars[i]);
        }
        return cars;
    }

    public static void main(String[] args) {
        List<String> carNames = getCars();
        List<Integer> numberOfCarSteps = new ArrayList<>();

        for (int i = 0; i < carNames.size(); i++) {
            numberOfCarSteps.add(0);
        }

    }
}
