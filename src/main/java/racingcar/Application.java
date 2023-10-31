package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Application {

    //Car 클래스 정의
    public static class Car {
        public String name;
        public int randomNumber; // 랜덤으로 받을 정수
        public int advanceCount = 0; // 전진 횟수

        public Car(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String[] carNames = inputCarNames(); // 자동차 이름 입력 받기
        int tries = inputTries(); // 시도 횟수 입력 받기
        Car[] cars = createCars(carNames); //자동차 객체 생성

        System.out.println("실행 결과");
        StartRacing(tries, cars); // 경주 시작
        printWinners(findWinners(cars, carNames));

    }

    private static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
        return carNames;
    }

    private static int inputTries() {
        System.out.println("시도할 회수는 몇회인가요?");
        int tries = Integer.parseInt(Console.readLine());  // 시도 횟수 입력 받기

        if (tries < 0) {
            throw new IllegalArgumentException("시도 횟수는 음수일 수 없습니다.");
        }

        return tries;
    }

    private static Car[] createCars(String[] carNames) {
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i] + " : ");
        }
        return cars;
    }

    private static void StartRacing(int tries, Car[] cars) {
        for (int i = 0; i < tries; i++) { // 시도 횟수 만큼 반복
           randomAssignment(cars);
        }
    }

    private static void randomAssignment(Car[] cars) {
        for (Car car : cars) {
            car.randomNumber = Randoms.pickNumberInRange(0, 9);
            if (car.randomNumber > 3) {
                car.advanceCount++;
                car.name = car.name.concat("-");
            }
        }
        printCars(cars);
    }

    private static void printCars(Car[] cars) {
        for (Car car : cars) {
            System.out.println(car.name);
        }
        System.out.println();
    }


    private static List<String> findWinners(Car[] cars, String[] carNames) {
        int maxAdvanceCount = findMaxAdvanceCount(cars);
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < cars.length; i++) {
            if (cars[i].advanceCount == maxAdvanceCount) {
                winners.add(carNames[i]);
            }
        }
        return winners;
    }

    private static int findMaxAdvanceCount(Car[] cars) {
        int max = cars[0].advanceCount;

        for (Car car : cars) {
            max = Math.max(max, car.advanceCount);
        }
        return max;
    }

    private static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");

        for (int i = 0; i < winners.size(); i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(winners.get(i));
        }
        System.out.println();
    }
}

