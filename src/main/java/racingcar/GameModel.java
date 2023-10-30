package racingcar;

import java.util.LinkedHashMap;
import java.util.Map;
import camp.nextstep.edu.missionutils.Randoms;

public class GameModel {
    private final Map<String, Integer> carData;
    public static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    public static final String HOW_MANY_TIMES_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String RESULT_MESSAGE = "실행 결과";
    public static final String LINE = "-";
    public static final String WINNER_MESSAGE = "최종 우승자 :";

    public GameModel() {
        this.carData = new LinkedHashMap<>();
    }

    public void insertCarToCarArray(String[] carNamesArray) {
        for (String carName : carNamesArray) {
            carData.put(carName, 0);
        }
    }

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean checkResult(int randInt) {
        return randInt >= 4;
    }

    public void putDataToCarData(String carName, int count) {
        carData.put(carName, carData.get(carName) + count);
    }

    public int findMaxPosition() {
        return carData.values().stream().max(Integer::compare).orElse(0);
    }

    public void saveResult(int count) {
        for (String carName : carData.keySet()) {
            saveCarResult(carName, count);
        }
    }

    public void saveCarResult(String carName, int count) {
        for (int j = 0; j < count; j++) {
            int randInt = createRandomNumber();
            if (checkResult(randInt)) {
                putDataToCarData(carName, 1);
            }
        }
    }

    public Map<String, Integer> getCarData() {
        return carData;
    }
}

