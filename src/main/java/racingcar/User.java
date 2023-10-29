package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class User {

    public String[] initCarList() {
        String carList = Console.readLine();

        String[] carArray = carList.split(",");
        // validate carArray

        return carArray;
    }

}
