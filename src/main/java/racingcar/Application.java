package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = inputCarNames(scanner);

        int numAttempts = getNumAttempts(scanner);

        if (numAttempts <= 0) {
            System.out.println("시도 횟수는 1 이상이어야 합니다.");
            return;
        }

        for (Car car : cars) {
            car.displayNameWithDash();
        }


    }
    private static List<Car> inputCarNames(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scanner.nextLine();
        if (!isValidCarNamesInput(input)) {
            throw new IllegalArgumentException("올바른 자동차 이름 형식이 아닙니다.");
        }

        String[] carNames = input.split(",");
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
    private static boolean isValidCarNamesInput(String input) {
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            if (carName.trim().isEmpty() || carName.length() > 5) {
                return false;
            }
        }
        return true;
    }
    private static int getNumAttempts(Scanner scanner) {
        System.out.println("시도할 회수는 몇회인가요?");
        int numAttempts = scanner.nextInt();
        return numAttempts;
    }
    static class Car {
        private String name;
        private int position;

        public Car(String name) {
            this.name = name;
            this.position = 0;
        }
        public void displayNameWithDash() {
            System.out.print(name + " : ");
            for (int i = 0; i < position; i++) {
                System.out.print("-");
            }
            System.out.println();
        }

    }
}