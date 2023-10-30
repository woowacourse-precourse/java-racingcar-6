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

    private static boolean isNumberic(String n) {
        try {
            Integer.parseInt(n);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static Integer getN() {
        System.out.println("시도할 회수는 몇회인가요?");
        String N = Console.readLine();

        // 예외 처리
        // N은 숫자 형태인가?
        if (!isNumberic(N))
            throw new IllegalArgumentException("숫자를 입력해주세요.");

        return Integer.parseInt(N);
    }

    public static void main(String[] args) {
        List<String> carNames = getCars();
        List<Integer> numberOfCarSteps = new ArrayList<>();

        for (int i = 0; i < carNames.size(); i++) {
            numberOfCarSteps.add(0);
        }

        Integer n = getN();

    }
}
