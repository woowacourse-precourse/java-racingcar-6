package racingcar.service;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.domain.Car;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;

public class InputService {
    // 사용자의 Input을 받는 서비스

    public static Integer requestRacingRound() {
        String roundString = InputView.roundInput();
        Integer round = transformRound(roundString);

        return round;
    }

    public static ArrayList<Car> requestRacingCars() {
        String carInput = InputView.carInput();
        validateCarInput(carInput);

        return transformCars(carInput);
    }

    private static Integer transformRound(String roundInput) {
        validateRoundInput(roundInput);
        return Integer.parseInt(roundInput);
    }

    private static ArrayList<Car> transformCars(String carNames){
        ArrayList<String> carNameList = new ArrayList<>(Arrays.asList(carNames.split(",")));
        validateCarDuplicatedName(carNameList);
        ArrayList<Car> cars = new ArrayList<>();

        for (String name : carNameList) {
            validateCarName(name);
            cars.add(new Car(name));
        }

        return cars;
    }

    private static void validateCarDuplicatedName(ArrayList<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);
        if (carNameList.size() != carNameSet.size()){
            throw new IllegalArgumentException("이름에 중복이 없는지 확인해주세요.");

        }
    }

    private static void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("차량의 이름이 6자 이상입니다.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("문자열에 공백이 포함되어 있습니다.");
        }
    }

    private static void validateCarInput(String carInput) {
        if (!carInput.matches("^[a-zA-Z,]*$")) {
            throw new IllegalArgumentException("영어 알파벳과 쉼표(,) 이외의 문자가 포함되어 있습니다.");
        }
    }

    private static void validateRoundInput(String roundInput) {
        try {
            int number = Integer.parseInt(roundInput);
            if (number == 0 || number < 0) {
                throw new IllegalArgumentException("숫자가 0 또는 음수입니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자가 아닙니다.");
        }
    }
}
