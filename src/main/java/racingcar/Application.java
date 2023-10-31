package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private List<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        System.out.println();
        generateCars(carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        int tries = Integer.parseInt(Console.readLine());
        System.out.println();

        System.out.println("\n실행 결과");
        for (int i = 0; i < tries; i++) {
            cars.forEach(car -> {
                car.move(randomNumber());
                System.out.println(car.getName() + " : " + car.getPositionString());
            });
            System.out.println();
        }

        String winners = determineWinners();
        System.out.println("최종 우승자 : " + winners);
    }

    private void generateCars(String carNames) {
        String[] names = carNames.split(",");
        for (String name : names) {
            // 이름이 공란이거나 너무 긴 경우 예외 발생
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차명은 공란일 수 없습니다.");
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5글자 이하만 가능합니다.");
            }
            cars.add(new Car(name));
        }
    }

    private int randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private String determineWinners() {
        // 변환된 정수 스트림에서 가장 큰 값을 찾음
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return String.join(", ", winners);
    }
}

class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }

    // 자동차의 현재 위치를 "-" 문자열로 반환하는 메소드
    public String getPositionString() {
        StringBuilder positionString = new StringBuilder();
        for (int i = 0; i < position; i++) {
            positionString.append("-");
        }
        return positionString.toString();
    }
}
