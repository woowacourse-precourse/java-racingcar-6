package model;

import static model.Number.BASE_NUMBER;
import static model.UtilityModel.getRandomNumber;

import java.util.ArrayList;
import java.util.List;

public class GameModel {
    public ArrayList<RacingCarInfo> racingCarInfos;

    public GameModel(String[] carNamesArray) {
        racingCarInfos = new ArrayList<RacingCarInfo>();
        int idx = 0;
        for (String name : carNamesArray) {
            RacingCarInfo carInfo = new RacingCarInfo(name, idx);
            racingCarInfos.add(carInfo);
            idx++;
        }
    }

    public void updateRaceStatus() {
        for (RacingCarInfo carInfo : racingCarInfos) {
            int randomNumber = getRandomNumber();
            carInfo.moveCount += compareRandomToBase(randomNumber);
        }
    }

    private int compareRandomToBase(int radomNumber) {
        if (radomNumber >= BASE_NUMBER) {
            return 1;
        }
        return 0;
    }

    public List<String> getWinnerNames() {
        int max = findMaxCountOfCarInfos();
        List<String> winnerNames = new ArrayList<>();

        for (RacingCarInfo carInfo : racingCarInfos) {
            addWinnerIfMaxCount(winnerNames, carInfo, max);
        }

        return winnerNames;
    }

    private int findMaxCountOfCarInfos() {
        int maxCount = 0;
        for (RacingCarInfo carInfo : racingCarInfos) {
            maxCount = Math.max(maxCount, carInfo.moveCount);
        }
        return maxCount;
    }

    private void addWinnerIfMaxCount(List<String> winnerNames, RacingCarInfo carInfo, int max) {
        if (carInfo.moveCount == max) {
            winnerNames.add(carInfo.name);
        }
    }
}

