package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Cars;

public class GameService {
    private static final int POSSIBLE = 4;
    Cars cars = new Cars();

    public ArrayList<List<String>> moveCar(ArrayList<String> carNames, ArrayList<List<String>> currentCarProgress) {

        for (int j = 0; j < carNames.size(); j++) {

            int currentCarMove = Randoms.pickNumberInRange(0, 9);
            //ArrayList<List<String>> currentCarProgress = cars.getCarProgress();

            if (currentCarMove >= POSSIBLE) {
                String currentMove = currentCarProgress.get(j).get(0);
                currentCarProgress.get(j).set(0, currentMove + "-");


            }

        }
        return currentCarProgress;

    }

    public ArrayList<String> getFinalWinner(ArrayList<String> carNames, ArrayList<List<String>> carProgress) {
        ArrayList<String> winnerList = new ArrayList<>();
        int maxDistance = getMaxCarTravelDistance(carNames, carProgress);

        for (int i = 0; i < carNames.size(); i++) {
            if (carProgress.get(i).get(0).length() == maxDistance) {
                winnerList.add(carNames.get(i));
            }

        }
        return winnerList;
    }

    private int getMaxCarTravelDistance(ArrayList<String> carNames, ArrayList<List<String>> carProgress) {
        int maxDistance = -1;
        for (int i = 0; i < carNames.size(); i++) {
            if (maxDistance < carProgress.get(i).get(0).length()) {
                maxDistance = carProgress.get(i).get(0).length();
            }
        }
        return maxDistance;
    }
}
