package racingcar.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FacadeService {
    public VerificationService verificationService = new VerificationService();
    public AddValueService addValueService;
    public CarRaceGameService carRaceGameService = new CarRaceGameService();
    public int max = Collections.max(carRaceGameService.getAllPosition());
    public int maxFrequency = Collections.frequency(carRaceGameService.getAllPosition(), max);
    public List<String> winnerList = new ArrayList<>();

    public String[] addCarName(String carNames) {
        if (verificationService.nameCheck(carNames)) {
            return addValueService.addCarNames(carNames);
        } else throw new IllegalArgumentException();

    }

    public int addCarCount(String count) {
        int carCount = 0;
        if (verificationService.countTypeCheck(count)) {
            carCount = addValueService.addCarCount(count);
        }return carCount;
    }

    public void findWinner() {
        if (maxFrequency == 1) {
            findWinnerName();
        } else {
            findWinnerList(max);
        }
    }


    public String findWinnerName() {
        String WinnerName = "";
        for (int i = 0; i < addValueService.carNameList.length; i++) {
            if (carRaceGameService.getPosition(i)[i] == max) {
                WinnerName = addValueService.carNameList[i];
            }
        }
        return WinnerName;
    }

    public List<String> findWinnerList(int max) {
        for (int i = 0; i < max; i++) {
            winnerList.add(i, findWinnerName());
        }
        return winnerList;
    }

}

