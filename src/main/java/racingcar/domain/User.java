package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.UserValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    public List<String> cars = new ArrayList<>();
    public int gameNumber;
    UserValidator validator = new UserValidator();

    public void InitialSetting() {
        InputCarName();
        CheckCarName();
        InputGameNumber();
    }

    public void InputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        cars = Arrays.asList(Console.readLine().split(","));
    }

    public void CheckCarName() {
        for (int i = 0; i < cars.size(); i++) {
            validator.CheckCarNameLength(cars.get(i));
        }
        for (int i = 0; i < cars.size(); i++) {
            validator.CheckCarNameNumber(cars.get(i));
        }
        validator.CheckCarNameDuplication(cars);
    }

    public void InputGameNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String gameNumberInputString = Console.readLine();
        CheckGameNumber(gameNumberInputString);
        int gameNumberInput = Integer.parseInt(gameNumberInputString);
        setGameNumber(gameNumberInput);
    }

    public void CheckGameNumber(String gameNumberInput) {
        validator.CheckGameNumberNull(gameNumberInput);
        validator.CheckGameNumberIsNumber(gameNumberInput);
    }

    public void setGameNumber(int gameNumberInput) {
        gameNumber = gameNumberInput;
    }

    public List<String> getCars() {
        return cars;
    }
}

