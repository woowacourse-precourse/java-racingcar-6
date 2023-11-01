package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // 입력 받기
            System.out.print("자동차 대수를 입력하세요: ");
            int carCount = scanner.nextInt();
            scanner.nextLine();  // 개행 문자 처리

            System.out.print("이동 횟수를 입력하세요: ");
            int moveCount = scanner.nextInt();
            scanner.nextLine();  // 개행 문자 처리

            // 자동차 이름 입력 받기
            List<Car> cars = new ArrayList<>();
            for (int i = 0; i < carCount; i++) {
                System.out.print("자동차 이름을 입력하세요: ");
                String name = scanner.nextLine().trim();
                cars.add(new Car(name));
            }

            // 경주 시작
            System.out.println("실행 결과");
            for (int i = 0; i < moveCount; i++) {
                for (Car car : cars) {
                    car.move();
                    System.out.println(car.getName() + " : " + car.getPositionString());
                }
                System.out.println();
            }

            // 우승자 결정
            int maxPosition = 0;
            for (Car car : cars) {
                maxPosition = Math.max(maxPosition, car.getPosition());
            }

            StringBuilder winners = new StringBuilder();
            for (Car car : cars) {
                if (car.getPosition() == maxPosition) {
                    if (winners.length() > 0) {
                        winners.append(", ");
                    }
                    winners.append(car.getName());
                }
            }

            System.out.println(winners + " 가 최종 우승했습니다!");

        } catch (Exception e) {
            System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
        }
    }
}

class Car {
    private final String name;
    private int position;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
        this.position = 0;
    }

    public void move() {
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        if (randomNumber >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionString() {
        StringBuilder positionString = new StringBuilder();
        for (int i = 0; i < position; i++) {
            positionString.append("-");
        }
        return positionString.toString();
    }
}
