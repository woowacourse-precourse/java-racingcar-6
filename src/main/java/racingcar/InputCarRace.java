package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputCarRace {
    private static List<String> carNames = new ArrayList<>();
    private static int moveCount = 0;

    public static InputCarRace inputMove(String stringMoveCount){
        validateOnlyNumber(stringMoveCount);
        moveCount = Integer.parseInt(stringMoveCount);
        OutputCarRace.printf(MessageType.INPUT_DATA_PRINT, stringMoveCount);
        return new InputCarRace();
    }

    public static int getMoveCount(){
        return moveCount;
    }

    private static void validateOnlyNumber(String stringMoveCount) {
        if (isOnlyNumber(stringMoveCount)) {
            throw new IllegalArgumentException("입력하신 내용엔 숫자외 값이 포함되었습니다.");
        }
    }

    private static boolean isOnlyNumber(String stringMoveCount){
        return !stringMoveCount.matches("[0-9]+");
    }

    public static InputCarRace inputCarNames(String stringCarNames){
        StringTokenizer st = new StringTokenizer(stringCarNames,",");

        while(st.hasMoreTokens()){
            String carName = st.nextToken();
            validateCarName(carName);
            carNames.add(carName);
        }

        validateDuplicateCarNames();
        OutputCarRace.printf(MessageType.INPUT_DATA_PRINT, stringCarNames);
        return new InputCarRace();
    }

    public static List<String> getCarNumbers(){
        return carNames;
    }

    private InputCarRace(){

    }

    private static void validateCarName(String carName){
        validateUnderFiveLength(carName);
        validateWhiteSpace(carName);
    }

    private static void validateUnderFiveLength(String carName) {
        if(isOverSixLength(carName)){
            throw new IllegalArgumentException("입력하신 차량 이름이 6자를 넘었습니다.");
        }
    }

    private static void validateWhiteSpace(String carName) {
        if(isWhiteSpace(carName)){
            throw new IllegalArgumentException("입력하신 차량은 공백입니다.");
        }
    }

    private static void validateDuplicateCarNames() {
        if(isDuplicateCarNames()){
            throw new IllegalArgumentException("입력하신 차량은 중복되었습니다.");
        }
    }

    private static boolean isOverSixLength(String carName){
        return carName.length() >= 6;
    }

    private static boolean isWhiteSpace(String carName) {
        return carName.isBlank();
    }

    private static boolean isDuplicateCarNames() {
        return carNames.size() != carNames.stream().distinct().count();
    }
}
