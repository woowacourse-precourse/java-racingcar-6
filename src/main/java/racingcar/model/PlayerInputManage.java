package racingcar.model;

import java.util.ArrayList;

public class PlayerInputManage {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String ERROR_MESSAGE_CAR_NAME_LENGTH = "자동차 이름은 5자 이하만 가능합니다.";
    private static final String ERROR_MESSAGE_CAR_NAME = "자동차 이름은 알파벳만 가능합니다.";
    private static final String ERROR_MESSAGE_TRY_COUNT = "시도 횟수는 숫자만 가능합니다.";
    private static final String ERROR_MESSAGE_TRY_COUNT_RANGE = "시도 횟수는 1이상만 가능합니다.";

    private static final String Commas = ",";
    private static final String REGEX = "^[a-zA-Z]*$";


    private static ArrayList<String> playerCarNameList;

    public PlayerInputManage(String CarNameInput, String playerTryCountInput) {
        CheckCountInput(playerTryCountInput);
        SetCarNameList(CarNameInput);
        CheckCarNameLength(this.playerCarNameList);
        CheckCarName(this.playerCarNameList);
    }

    private void SetCarNameList(String carNameInput) {
        this.playerCarNameList = new ArrayList<>();
        for(String carName : carNameInput.split(Commas)) {
            this.playerCarNameList.add(carName);
        }
    }

    public static void CheckCarNameLength(ArrayList<String> playerCarNameList) {
        for (String carName : playerCarNameList) {
            if (carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(ERROR_MESSAGE_CAR_NAME_LENGTH);
            }
        }
    }

    // 중복, 공백 체크
    


    public static void CheckCarName(ArrayList<String> playerCarNameList) {
        for (String carName : playerCarNameList) {
            if (!carName.matches(REGEX)) {
                throw new IllegalArgumentException(ERROR_MESSAGE_CAR_NAME);
            }
        }
    }

    public static void CheckCountInput(String playerTryCountInput){

        if(!playerTryCountInput.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(ERROR_MESSAGE_TRY_COUNT);
        }

        if(Integer.parseInt(playerTryCountInput) < 1) {
            throw new IllegalArgumentException(ERROR_MESSAGE_TRY_COUNT_RANGE);
        }
    }

    public static ArrayList<String> getPlayerCarNameList() {
        return playerCarNameList;
    }

}
