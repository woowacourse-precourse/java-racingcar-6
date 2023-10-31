package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    static List<Car> carList = new ArrayList<>();
    
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = Arrays.asList(input.split(","));
        checkCarName(carNames);
    }

    public static void checkCarName(List<String> carNames) {
        for(String name : carNames) {
            name = name.trim();
            if(name.length() > 5 || name.isEmpty()) {
                throw new IllegalArgumentException();
            }
            carList.add(new Car(name));
        }
    }

    public static int inputTry() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return checkTry(input);
    }

    public static int checkTry(String input) {
        try {
            int num = Integer.parseInt(input);
            if(num <= 0) {
                throw new IllegalArgumentException();
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
