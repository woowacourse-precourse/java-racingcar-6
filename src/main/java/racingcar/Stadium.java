package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

class Stadium {
    int first_pos;
    List<Car> cars;

    public Stadium() {
        first_pos = 0;
        cars = new ArrayList<>();
    }

    public void carsEnter(String line) throws IllegalArgumentException {
        List<String> carNames = Arrays.asList(line.split(","));
        for (String name : carNames) {
            validateName(name);
            cars.add(new Car(name));
        }
    }

    private static void validateName(String string) throws IllegalArgumentException {
        if (string.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void race() throws IllegalArgumentException {
        print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        carsEnter(names);
        print("시도할 회수는 몇회인가요?");
        String maxTurn = Console.readLine();
        int turn = validateNumber(maxTurn);
        print("\n실행결과");
        for (int i = 0; i < turn; i++) {
            raceOne();
            getStatus();
            print("");
        }
        print(String.format("최종 우승자 : %s", winner()));
    }

    private static int validateNumber(String line) throws IllegalArgumentException {
        for (char ch : line.toCharArray()) {
            if ('0' > ch || ch > '9') {
                throw new IllegalArgumentException();
            }
        }
        return Integer.parseInt(line);
    }

    public void raceOne() {
        for (Car car : cars) {
            int number = Randoms.pickNumberInRange(0, 9);
            tryMove(car, number);
        }


    }

    public void tryMove(Car car, int num) {
        if (forwardSuccessCheck(num)) {
            car.setPos(car.getPos() + 1);
        }
        if (first_pos < car.getPos()) {
            first_pos = car.getPos();
        }
    }

    public static boolean forwardSuccessCheck(int randomNumber) {
        return (randomNumber >= 4);
    }

    public void getStatus() {
        for (Car car : cars) {
            print(showCar(car));
        }
    }

    public static String showCar(Car car) {
        String dash = "-".repeat(car.getPos());
        return String.format("%s : %s", car.getName(), dash);
    }

    private static void print(String s) {
        System.out.println(s);
    }

    public String winner() {
        StringJoiner stringjoiner = new StringJoiner(", ");
        for (Car car : cars) {
            if (car.getPos() == first_pos) {
                stringjoiner.add(car.getName());
            }
        }
        return stringjoiner.toString();
    }


}