package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    ArrayList<String> winnerList = new ArrayList<>();

    public ArrayList<String> getWinnerList() {
        return winnerList;
    }

    public void setWinnerList(ArrayList<String> winnerList) {
        this.winnerList = winnerList;
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
