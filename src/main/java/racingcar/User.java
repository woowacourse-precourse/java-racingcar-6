package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {

    /** Get Car Names From User
     *  사용자로부터 자동차 이름을 입력받는 메서드
     */
    public List<String> getCarNamesFromUser() {

        String carName = Console.readLine();

        List<String> carNames = new ArrayList<>(Arrays.asList(carName.split(",")));

        return carNames;
    }
}
