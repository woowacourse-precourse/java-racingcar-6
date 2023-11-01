package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FacadeService {
    public VerificationService verificationService = new VerificationService();
    public AddValueService addValueService = new AddValueService();
    public CarRaceGameService carRaceGameService = new CarRaceGameService();
    public int max = Collections.max(setAllPositions());
    public int maxFrequency = Collections.frequency(setAllPositions(), max);
    public List<String> winnerList = new ArrayList<>();


    public String[] addCarName(String carNames) {
        int carNameLength = addValueService.addCarNames(carNames).length;
        String[] carName = new String[carNameLength];

        for (int i = 0; i < carNameLength; i++) {
            carName[i] = addValueService.addCarNames(carNames)[i];

            if (verificationService.nameCheck(carName[i])) {
                carName[i] = addValueService.addCarNames(carNames)[i];
            } else throw new IllegalArgumentException();

        }
        return carName;
    }

    public int addCarCount(String count) {
        int carCount = 0;
        if (verificationService.countTypeCheck(count)) {
            carCount = addValueService.addCarCount(count);
        }
        return carCount;
    }

    public void findWinner(String carNames) {
        if (maxFrequency == 1) {
            findWinnerName(carNames);
        } else {
            findWinnerList(max, carNames);
        }
    }


    public String findWinnerName(String carNames) {
        String WinnerName = "";
        for (int i = 0; i < addValueService.addCarNames(carNames).length ;i++) {
            if (carRaceGameService.getPosition(i)[i] == max) {
                WinnerName = addValueService.carNameList[i];
            }
        }
        return WinnerName;
    }

    public List<Integer> setAllPositions() {
        List<Integer> allPositions = new ArrayList<>();
        for (int i = 0; i < addValueService.carNameList.length; i++) {
            allPositions = carRaceGameService.getAllPosition(i);
        }
        return allPositions;
    }


    public List<String> findWinnerList(int max, String carNames) {
        for (int i = 0; i < max; i++) {
            winnerList.add(i, findWinnerName(carNames));
        }
        return winnerList;
    }


}

