package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Cars;

public class GameService {
    private static final int POSSIBLE = 4;
    private static final int ZERO = 0;
    private static final int NINE = 0;
    Cars cars = new Cars();

    public ArrayList<List<String>> moveCar(ArrayList<String> carNames, ArrayList<List<String>> currentCarProgress) {

        for (int j = 0; j < carNames.size(); j++) {

            int currentCarMove = Randoms.pickNumberInRange(ZERO, NINE);

            if (currentCarMove >= POSSIBLE) {
                String currentMove = currentCarProgress.get(j).get(0);
                currentCarProgress.get(j).set(0, currentMove + "-");

            }

        }
        return currentCarProgress;

    }


}
