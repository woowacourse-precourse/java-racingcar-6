package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        System.out.println(input);

        System.out.println("시도할 회수는 몇회인가요?");
        String inputNum = Console.readLine();
        int inputNumber = Integer.parseInt(inputNum);

        System.out.println(inputNum);

        String[] carNames = input.split(",");

        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해야 합니다.");
            }
        }

        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }

        for (int i = 0; i < inputNumber; i++) {
            for (Car car : cars) {
                car.move();
            }
            printRace(cars);
        }

        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        // 우승자 출력
        System.out.print("최종 우승자 : ");
        boolean isFirstWinner = true;
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                if (!isFirstWinner) {
                    System.out.print(", ");
                }
                System.out.print(car.getName());
                isFirstWinner = false;
            }
        }

    }

    private static void printRace(Car[] cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    static class Car {
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
            int randomNumber = Randoms.pickNumberInRange(0, 9); // 0에서 9 사이의 무작위 값
            System.out.println("랜덤숫자:"+randomNumber);
            if (randomNumber >= 4) {
                position++;
            }
        }
    }
}
