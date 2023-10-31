package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Create {


    public String[] checkCarsName(String names) {

        String[] namelist = names.split(",");
        Judgment judgment = new Judgment();
        judgment.checkCarName(List.of(namelist), names);
        return namelist;
    }

    public int generateRandomNumbers() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public int howManyTimesGameStart(String input) {
        int howManyMoves;
        try {
            howManyMoves = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 정수로 입력해주세요.");
        }

        if (howManyMoves < 1) {
            throw new IllegalArgumentException("시도할 횟수는 0보다 큰 수를 입력해주세요.");
        }

        return howManyMoves;
    }


}
