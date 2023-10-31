package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Racing {

    private static void checkNameException(String name) {
        if (name.length() > 5 || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 1~5자로 입력해주세요.");
        }
    }

    private static boolean isPositive(int number) {
        return number > 0;
    }

    private static int transformStringToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    public int getTurn() {
        System.out.println("시도할 회수는 몇회인가요?");
        final int turn = transformStringToInt(Console.readLine());
        if(isPositive(turn)){
            return turn;
        }
        throw new IllegalArgumentException("1 이상의 숫자를 입력해주세요.");
    }

    public List<Car> getCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String carNameString = Console.readLine();
        List<Car> carList = new ArrayList<>();
        for (String carName : Arrays.stream(carNameString.split(",")).toList()) {
            checkNameException(carName);
            final Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }


    private void start(List<Car> cars, int turn) {
        int maxScore = 0;

        System.out.println("실행 결과");
        for (int i = 0; i < turn; i++) {
            maxScore = cars.stream().mapToInt(Car::run).max().orElse(0);
            System.out.println();
        }

        List<String> winner = new ArrayList<>();
        for (Car car : cars) {
            final String carName = car.ifMaxScore(maxScore);
            if (!carName.isEmpty()) {
                winner.add(carName);
            }
        }
        String winnerFormat = String.format("최종 우승자 : %s", String.join(", ", winner));
        System.out.println(winnerFormat);
    }

    public void ready() {
        final List<Car> cars = getCarList();
        int turn = getTurn();
        start(cars, turn);
    }
}
