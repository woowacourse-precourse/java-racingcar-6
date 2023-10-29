package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class Racing {
    private List<Car> cars;
    private final int turn;
    public Racing(List<Car> cars, int turn) {
        this.cars = cars;
        this.turn = turn;
    }

    public void startRacing() {
        System.out.println("실행결과");
        for (int i = 0; i < turn; i++) {
            for (Car car : cars) {
                car.move();
            }
            printTurnResult();
            System.out.println();
        }
    }

    public List<Car> getWinners() {
        Map<Integer, List<Car>> map = new HashMap<>();
        for (Car car : cars) {
            if (map.get(car.getMovedDist()) == null) {
                List<Car> carList = new ArrayList<>();
                carList.add(car);
                map.put(car.getMovedDist(), carList);
                continue;
            }
            map.get(car.getMovedDist()).add(car);
        }
        return map.get(Collections.max(map.keySet()));
    }

    private void printTurnResult() {
        for (Car car : cars) {
            String result = car.getName() + " : " +
                    "-".repeat(Math.max(0, car.getMovedDist()));
            System.out.println(result);
        }
    }


    public static Racing createRacingWithInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carList = Arrays.stream(Console.readLine().split(","))
                .map(String::trim).collect(Collectors.toList());
        if (!validateCreateRacingCarInput(carList)) {
            throw new IllegalArgumentException("중복되지 않는 자동차 이름을 입력해주세요.");
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int turn = Integer.parseInt(Console.readLine());
        if (turn <= 0) {
            throw new IllegalArgumentException("0보다 큰 회수를 입력해주세요.");
        }

        List<Car> cars = new ArrayList<>();
        for (String name : carList) {
            cars.add(new Car(name));
        }

        return new Racing(cars, turn);
    }

    private static boolean validateCreateRacingCarInput(List<String> carList) {
        Set<String> set = new HashSet<>();
        for (String carStr : carList) {
            // 자동차 이름 5자 이하 체크
            if (carStr.length() > 5) {
                return false;
            }

            // 자동차 이름 중복 체크
            if (set.contains(carStr)) {
                return false;
            }
            set.add(carStr);
        }
        return true;
    }
}
