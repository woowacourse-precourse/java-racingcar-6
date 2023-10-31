package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PlayerInputManage {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String ERROR_MESSAGE_CAR_NAME_LENGTH = "자동차 이름은 5자 이하만 가능합니다.";
    private static final String ERROR_MESSAGE_CAR_NAME = "자동차 이름은 알파벳만 가능합니다.";
    private static final String ERROR_MESSAGE_TRY_COUNT = "시도 횟수는 숫자만 가능합니다.";
    private static final String ERROR_MESSAGE_TRY_COUNT_RANGE = "시도 횟수는 1이상만 가능합니다.";
    private static final String ERROR_MESSAGE_CAR_NAME_DUPLICATE = "자동차 이름은 중복이 불가능합니다.";

    private static final String Commas = ",";
    private static final String REGEX = "^[a-zA-Z]*$";
    private static final String REGEX_INTEGER_ONLY = "^[\\d]$";


    private static ArrayList<Car> playerCarNameList;

    public PlayerInputManage(String CarNameInput, String playerTryCountInput) {
        CheckCountInput(playerTryCountInput);
        SetCarNameList(CarNameInput);
        CheckCarNameLength(this.playerCarNameList);
        CheckCarName(this.playerCarNameList);
        CheckCarNameDuplication(this.playerCarNameList);
    }

    private void SetCarNameList(String carNameInput) {
        this.playerCarNameList = new ArrayList<>();
        for(String carName : carNameInput.split(Commas)) {
            this.playerCarNameList.add(new Car(carName));
        }
    }

    public static void CheckCarNameLength(ArrayList<Car> playerCarNameList) {
        for (Car carName : playerCarNameList) {
            if (carName.getName().length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(ERROR_MESSAGE_CAR_NAME_LENGTH);
            }
        }
    }

    public static void CheckCarNameDuplication(ArrayList<Car> playerCarNameList) {
        Set<Car> set = new HashSet<>(playerCarNameList);

        if(set.size() != playerCarNameList.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_CAR_NAME_DUPLICATE);
        }
    }


    public static void CheckCarName(ArrayList<Car> playerCarNameList) {
        for (Car carName : playerCarNameList) {
            if (!carName.getName().matches(REGEX)) {
                throw new IllegalArgumentException(ERROR_MESSAGE_CAR_NAME);
            }
        }
    }

    public static void CheckCountInput(String playerTryCountInput) {
        if(!playerTryCountInput.matches(REGEX_INTEGER_ONLY)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_TRY_COUNT);
        }

        if(Integer.parseInt(playerTryCountInput) < 1) {
            throw new IllegalArgumentException(ERROR_MESSAGE_TRY_COUNT_RANGE);
        }
    }

    public static ArrayList<Car> getPlayerCarNameList() {
        return playerCarNameList;
    }

}
