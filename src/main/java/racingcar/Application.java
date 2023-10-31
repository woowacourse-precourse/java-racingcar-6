package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");

        String input = Console.readLine();
        validateNameLength(input);
        String[] carNames = splitcarname(input);

        System.out.println("시도할 회수는 몇회인가요?");
        int count = Integer.parseInt(Console.readLine());

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }

        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            for (Car car : cars) {
                car.tryMove();
                System.out.println(car.getName() + " : " + car.getMove());
            }
            System.out.println();
        }

        List<String> winners = getWinners(cars);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public static void validateNameLength(String input) {
        int MAX_NAME_LENGTH = 5;
        String[] names = input.split(",");
        for (String name : names) {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은" + MAX_NAME_LENGTH + "자를 초과할 수 없습니다.");
            }
        }
    }

    public static String[] splitcarname(String input) {
        String[] result = input.split(",");
        return result;
    }
    public static List<String> getWinners(List<Car> cars) {
        int maxMove = cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMoveCount() == maxMove) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}

class Car {
    private final String name;
    private int move = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return move;
    }

    public String getMove() {
        return "-".repeat(move);
    }

    public void tryMove() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (randomValue >= 4) {
            move++;
        }
    }
}
    /*public static int[] decideCarAction(String[] carnames){
        int carCount = carnames.length;
        int[] movementCode = new int[carCount];

        for(int i=0; i<carCount; i++){
            movementCode[i] = Randoms.pickNumberInRange(0,9);
        }
        return movementCode;
    }

    public static String moveForward(){

        String[] moveCount =
        "-"+;
        return
    }
}*/
