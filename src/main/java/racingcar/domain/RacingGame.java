package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
    // 횟수 반복문으로 처리해서 전진 혹은 멈춤 하면서 map 갱신하기, 각 차수별 출력하기
    // 우승자 출력은 따로 ㄱㄱ

    User user = new User();
    private int attempts;
    private Integer totalCars;
    private List<String> carsNameList;
    private final List<Integer> carsPositionList = new ArrayList<>();

    public void playGame() {
        user.setCarsName();
        user.setAttempts();
        attempts = user.getAttempts();
        carsNameArrayToList(user.getCarsNameArray());
        setCarPositionList();
        System.out.println(carsNameList);
        System.out.println(carsPositionList);
    }

    public void carsNameArrayToList(String[] array) {
        carsNameList = Arrays.asList(array);
        totalCars = carsNameList.size();
    }

    public void setCarPositionList() {
        for (int i = 0; i < totalCars; i++) {
            carsPositionList.add(0);
        }
        startRaceAttempts();
    }

    public void startRaceAttempts() {
        for(int i = 0; i < attempts; i++) {
            singleRaceAttempt();
        }
    }

    public void singleRaceAttempt() {
        for(int j = 0; j < totalCars; j++) {
            int randomDigit = Randoms.pickNumberInRange(0, 9);
            if(randomDigit >= 4 && randomDigit <= 9) {
                int positionPlusOne = carsPositionList.get(j)+1;
                carsPositionList.set(j, positionPlusOne);
            }
        }
    }
}