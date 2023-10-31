package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    static List<Car> carList = new ArrayList<>();
    static int maxPostion = 0;
    
    public static void main(String[] args) {
        startRace();
    }

    public static void startRace() {
        inputCarName();
        int tries = inputTry();
        System.out.println();
        System.out.println("실행결과");
        while(true) {
            if(tries == 0) break;
            racing();
            System.out.println();
            tries--;
        }
        System.out.println("최종 우승자 : " + String.join(", ", checkWinner()));
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

    public static void racing() {
        for(Car car : carList) {
            car.moveForward();
            maxPostion = Math.max(maxPostion, car.getPosition());
            String tempPosition = "-".repeat(car.getPosition());
            System.out.println(car.getName() + " : " + tempPosition);
        }
    }

    public static List<String> checkWinner() {
        List<String> winnerList = new ArrayList<>();
        for(Car car : carList) {
            if(maxPostion == car.getPosition()) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }
}
