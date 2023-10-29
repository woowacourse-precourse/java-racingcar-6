package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Cars;

public class GameService {
    private static final int POSSIBLE = 4;
    Cars cars = new Cars();

    public void moveCar() {

        for (int j = 0; j < cars.getCarNameList().size(); j++) {

            int currentCarMove = Randoms.pickNumberInRange(0, 9);
            ArrayList<List<String>> currentCarProgress = cars.getCarProgress();

            if (currentCarMove >= POSSIBLE) {
                String currentMove = currentCarProgress.get(j).get(0);
                currentCarProgress.get(j).set(0, currentMove + "-");
                cars.setCarProgress(currentCarProgress);

            }

        }

    }

    public ArrayList<String> getFinalWinner() {
        ArrayList<String> winnerList = new ArrayList<>();
        int maxDistance = getMaxCarTravelDistance();

        for (int i = 0; i < cars.getCarNameList().size(); i++) {
            if (cars.getCarProgress().get(i).get(0).length() == maxDistance) {
                winnerList.add(cars.getCarNameList().get(i));
            }

        }
        return winnerList;
    }

    private int getMaxCarTravelDistance() {
        int maxDistance = -1;
        for (int i = 0; i < cars.getCarNameList().size(); i++) {
            if (maxDistance < cars.getCarProgress().get(i).get(0).length()) {
                maxDistance = cars.getCarProgress().get(i).get(0).length();
            }
        }
        return maxDistance;
    }
}
