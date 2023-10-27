package racingcar.View;

import racingcar.Car.Car;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;


public class InputView {
    public static List<Car> promptCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        List<Car> carsList = new ArrayList<>();
        Set<String> carNamesSet = new HashSet<>();

        for (String name : input.split(",")) {
            String trimmedName = name.trim();

            if (trimmedName.isEmpty() || trimmedName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하 여야 한다.");
            }

            if (!carNamesSet.add(trimmedName)) {
                throw new IllegalArgumentException("중복된 자동차 이름은 허용되지 않습니다: " + trimmedName);
            }

            carsList.add(new Car(trimmedName));
        }

        return carsList;
    }

    public static int promptNumber(){
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            int number = Integer.parseInt(Console.readLine());
            if (number <= 0) {
                throw new IllegalArgumentException("시도할 회수는 1회 이상이어야 합니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.", e);
        }
    }


}
