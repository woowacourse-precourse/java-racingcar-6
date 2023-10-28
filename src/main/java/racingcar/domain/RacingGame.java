package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {

    User user = new User();
    private int attempts;
    private Integer totalCars;
    private List<String> carsNameList;
    private final List<Integer> carsPositionList = new ArrayList<>();
    private static final int MIN_CAR_FORWARD_NUM = 4;
    private static final int MAX_CAR_FORWARD_NUM = 9;
    private static final int MIN_RANDOM_NUM = 0;
    private static final int MAX_RANDOM_NUM = 9;

    public void playGame() {
        user.setCarsName();
        user.setAttempts();
        attempts = user.getAttempts();

        carsArrayToList(user.getCarsNameArray());
        setPositionList();
        startRaceAttempts();

        System.out.println(carsNameList);
        System.out.println(carsPositionList);
    }

    public void carsArrayToList(String[] array) {
        carsNameList = Arrays.asList(array);
    }

    public void setPositionList() {
        totalCars = carsNameList.size();
        for (int i = 0; i < totalCars; i++) {
            carsPositionList.add(0);
        }
    }

    public void startRaceAttempts() {
        for(int i = 0; i < attempts; i++) {
            singleRaceAttempt(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
        }
    }

    public void singleRaceAttempt(int min, int max) {
        for(int j = 0; j < totalCars; j++) {
            int randomDigit = Randoms.pickNumberInRange(min, max);
            if(randomDigit >= MIN_CAR_FORWARD_NUM && randomDigit <= MAX_CAR_FORWARD_NUM) {
                int positionPlusOne = carsPositionList.get(j)+1;
                carsPositionList.set(j, positionPlusOne);
            }
        }
    }

    public List<String> getCarsList() {
        return carsNameList;
    }

    public List<Integer> getCarsPositionList() {
        return carsPositionList;
    }
}
