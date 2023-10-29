package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UserInput {
    public static List<String> getCarNames() {
        String input = Console.readLine();
        List<String> CarNameList = NameValidator.splitComma(input);
        return CarNameList;
        // validate가 되면 List<Car> 에 객체로 넣는다. (CarGenerator - createCarList 에서)
    }

    public void setRoundOfGame() {

    }
}
