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

        List<String> carNameList  = Arrays.stream(input.split(","))
                                        .map(carName -> carName.strip())
                                        .toList();

        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNameList.size(); i++) {
            Car car = new Car(carNameList.get(i), 0);
            carList.add(car);
        }

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
    }
}
