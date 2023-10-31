package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputCar = Console.readLine();

        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분): ");

        String[] carNames = inputCar.split(",");
        int carCounts = carNames.length;

        System.out.println("시도할 회수는 몇 회인가요? ");
        int inputTrys = Integer.parseInt(Console.readLine());

        if (inputTrys <= 0 || carCounts <= 0) {
            throw new IllegalArgumentException("[ERROR 잘못된 입력 값입니다. 프로그램을 종료합니다.]");
        }

        Car[] cars = new Car[carCounts];
        for (int i = 0; i < carCounts; i++) {
            cars[i] = new Car(carNames[i]);
        }

        System.out.println("실행 결과");

        for (int trys = 1; trys <= inputTrys; trys++) {
            System.out.println("시도 " + trys);
            for (Car car: cars) {
                car.move();
                System.out.println(car.getName() + " : " + car.getPosition());
            }
        }

        int maxPosition = 0;

        for (Car car: cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        System.out.print("최종 우승자: ");
        boolean firstWinner = true;

        for (Car car: cars) {
            if(car.getPosition() == maxPosition) {
                if(!firstWinner) {
                    System.out.print(", ");
                }
                System.out.println(car.getName());
                firstWinner = false;
            }
        }
        System.out.println();

    }
}

class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            position++;
        }
    }
}
