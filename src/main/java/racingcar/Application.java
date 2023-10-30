package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static racingcar.Constant.InputMenu.*;
import static racingcar.Constant.OutputMenu.*;
import static racingcar.Constant.RacingMenu.PLUS_SCORE;

public class Application {
    public static void main(String[] args) {
        System.out.println(INPUT_CAR_NAME);
        String carsInput = Console.readLine();
        Map<String, String> carList = Arrays.stream(carsInput.split(COMMA)).collect(Collectors.toMap(car -> car, car -> BLANK));


        for (String car : carList.keySet()) {
            if (car.length() > CAR_NAME_MAXIMUM_LENGTH) throw new IllegalArgumentException(EXCEPTION_INVALID_CAR_NAME);
        }

        System.out.println(INPUT_COUNT);
        String countInput = Console.readLine();
        int count;
        try {
            count = Integer.parseInt(countInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEPTION_INVALID_INTEGER);
        }

        if (count == 0) throw new IllegalArgumentException(EXCEPTION_INVALID_INTEGER_ZERO);


        System.out.println(OUTPUT_RESULT);
        for (int i = 0; i < count; i++) {
            for (Map.Entry<String, String> car : carList.entrySet()) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= 4) car.setValue(car.getValue() + PLUS_SCORE);
                System.out.println(car.getKey() + COLON + car.getValue());
            }
            System.out.println();
        }

        List<String> carNameByKeyDesc = new ArrayList<>(carList.keySet());
        carNameByKeyDesc.sort((value1, value2) -> Integer.compare(carList.get(value2).length(), carList.get(value1).length()));

        System.out.print(FINAL_WINNER);
        String firstWinner = carNameByKeyDesc.get(0);
        int max = carList.get(firstWinner).length();
        System.out.print(firstWinner);

        for (int i = 1; i < carNameByKeyDesc.size(); i++) {
            String carName = carNameByKeyDesc.get(i);
            if (carList.get(carName).length() != max) break;
            System.out.print(COMMA_AND_SPACE + carName);
        }
    }
}
