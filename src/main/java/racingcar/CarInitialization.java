package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarInitialization {//TESTese
    public static List<Car> initializeCars() {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();

        System.out.print("참가할 자동차 수를 입력하세요: ");
        int numberOfCars = scanner.nextInt();
        scanner.nextLine();  // 개행 문자 처리

        for (int i = 0; i < numberOfCars; i++) {
            System.out.print("자동차 " + (i + 1) + "의 이름을 입력하세요 (5자 이내): ");
            String carName = scanner.nextLine().trim();
            if (carName.length() > 5) {
                System.err.println("자동차 이름은 5자 이내여야 합니다. 다시 입력하세요.");
                i--;  // 잘못된 입력을 보정하기 위해 인덱스를 줄입니다.
            } else {
                cars.add(new Car(carName));
            }
        }

        return cars;
    }
}