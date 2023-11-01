package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;



class InputCarName {
    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = Console.readLine();
        String[] carNames = carNameInput.split(",");
        validateCarNames(carNames);
        return carNames;
    }

    private static void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5글자 이하여야 합니다.");
            }
        }
    }
}

class InputTryNumber {
    public static int getTryNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String tryNumberInput = Console.readLine();
        validateTryNumberInput(tryNumberInput);
        return Integer.parseInt(tryNumberInput);
    }

    private static void validateTryNumberInput(String tryNumberInput) {
        if (!isNumeric(tryNumberInput)) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        int tryNumber = Integer.parseInt(tryNumberInput);
        if (tryNumber <= 0) {
            throw new IllegalArgumentException("게임이 종료됩니다.");
        }
    }

    private static boolean isNumeric(String str) {
        String pattern = "^[0-9]*$";
        return Pattern.matches(pattern, str);
    }
}

class Race {
    private List<Car> cars;
    private int rounds;

    public Race(String[] carNames, int rounds) {
        this.rounds = rounds;
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void startRace() {
        for (int i = 0; i < rounds; i++) {
            moveCars();
            displayRoundResult();
            System.out.println();
        }
        displayWinners();
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void displayRoundResult() {
        for (Car car : cars) {
            car.displayCurrentPosition();
        }
    }

    private void displayWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        System.out.print("최종 우승자 : ");
        System.out.print(String.join(", ", winners));
    }

    private int getMaxPosition() {
        int max = -1;//명시적 초기화
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        return max;
    }
}

class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if (MoveConditionCar.isMoving()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void displayCurrentPosition() {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}

class MoveConditionCar {
    public static boolean isMoving() {
        return RandomNumber.pickRandomNumber() >= 4;
    }
}

class RandomNumber {
    public static int pickRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
