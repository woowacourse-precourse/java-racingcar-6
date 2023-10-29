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

    public int initCount() {
        String countStr = Console.readLine();

        int count = Integer.parseInt(countStr);
        // validate count

        return count;
    }

}
