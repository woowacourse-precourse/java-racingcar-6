package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GoOrStop {
    public static List<String> carAccelerator(List<String> carList) {
        List<String> carListAfterRound = new ArrayList<>();
        int index = 0;
        while (index < carList.size()) {
            String car = carList.get(index);
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (randomNumber >= 4) {
                car = car + "-";
            }
            carListAfterRound.add(car);
            index++;
        }

        return carListAfterRound;
    }
}
