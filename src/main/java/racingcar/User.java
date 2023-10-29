package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class User {

    public String[] initCarList() {
        String carList = Console.readLine();

        String[] carArray = carList.split(",");
        validateCarArray(carArray);

        return carArray;
    }

    public int initCount() {
        String countStr = Console.readLine();
        int count = 0;

        try {
            count = Integer.parseInt(countStr);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        return count;
    }

    private void validateCarArray(String[] carArray) {
        for (String carName : carArray) {
            int nameLength = carName.length();
            if (nameLength > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

}
