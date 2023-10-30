package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        List<String> carNameList = stripCarName(splitCarName(input));

        List<Car> carList = initializeCars(carNameList);

        for (Car car : carList) {
            String carName = car.getName();
            if (carName.isBlank()) {
                throw new IllegalArgumentException("이름을 입력해주세요.");
            }

            if (carName.length() > 5) {
                throw new IllegalArgumentException("이름은 공백 포함 5자 이하여야 합니다.");
            }
        }

        long sizeAfterDistinct = carList.stream().distinct().count();
        if (sizeAfterDistinct != carList.size()) {
            throw new IllegalArgumentException("중복된 이름입니다.");
        }

        System.out.println("시도할 회수는 몇회인가요?");

        String answer = Console.readLine();

        if (answer.length() > 9) {
            throw new IllegalArgumentException("시도 횟수는 10자리 미만의 수여야 합니다.");
        }

        int ans;
        try {
            ans = Integer.parseInt(answer);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        if (ans < 0) {
            throw new IllegalArgumentException("시도 횟수는 0번 이상이어야 합니다.");
        }

        StringBuilder[] result = new StringBuilder[carList.size()];
        for (int i=0; i<carList.size(); i++) {
            Car car = carList.get(i);

            result[i] = new StringBuilder();
            StringBuilder info = new StringBuilder(car.getName() + " : ");
            result[i].append(info);
        }

        System.out.println("\n실행 결과");
        for (int j=0; j<ans; j++) {
            for (int i = 0; i < carList.size(); i++) {
                Car car = carList.get(i);

                int random = Randoms.pickNumberInRange(0, 9);

                if (random >= 4) {
                    result[i].append("-");
                    car.increaseMoveCount();
                }
                System.out.println(result[i].toString());
            }
            System.out.println();
        }

        Integer max = carList.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .getAsInt();

        String winners = carList.stream()
                .filter(car -> car.getMoveCount() == max)
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.print("최종 우승자 : " + winners);
    }

    private static List<String> splitCarName(String input) {
        return Arrays.asList(input.split(","));
    }

    private static List<String> stripCarName(List<String> carNameList) {
        carNameList.replaceAll(String::strip);
        return carNameList;
    }

    private static List<Car> initializeCars(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNameList.size(); i++) {
            Car car = initializeCar(carNameList, i);
            carList.add(car);
        }
        return carList;
    }

    private static Car initializeCar(List<String> carNameList, int i) {
        Car car = new Car(carNameList.get(i), 0);
        return car;
    }
}
