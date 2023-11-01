package racingcar.util;

import java.util.List;

public class Validate {
    private static final int CAR_NAME_LIMIT_MAX = 5;
    private static final String SPACE = " ";
    private final InputPoint inputPoint = new InputPoint();
    //자동차 이름 검사
    public void checkInput_CarName(String input) throws IllegalArgumentException {
        List<String> carNameList = inputPoint.inputCarNames(input);
        checkCarName_NotEqual(carNameList);
        checkCarName_LengthLimit_NotSpace(carNameList);
    }
    //같은 자동차 이름이 있는지 확인
    private void checkCarName_NotEqual(List<String> carNameList) {
        for (int i = 0; i < carNameList.size(); i++) {
            for (int j = i + 1; j < carNameList.size(); j++) {
                checkNotEqual(carNameList.get(i), carNameList.get(j));
            }
        }
    }
    //같은 자동차 이름이 있으면 오류 호출
    private void checkNotEqual(String carName1, String carName2) {
        if (carName1.equals(carName2)) {
            throw new IllegalArgumentException("[ERROR] 같은 이름을 가진 자동차가 있습니다.");
        }
    }
    //자동차 이름의 길이와 공백 확인
    private void checkCarName_LengthLimit_NotSpace(List<String> carNameList) {
        for (String carName : carNameList) {
            checkLength_Limit(carName);
            checkNotSpace(carName);
        }
    }
    //자동차 이름의 길이 확인
    private void checkLength_Limit(String carName) {
        if (CAR_NAME_LIMIT_MAX < carName.length()) {
            throwMaxLength_Exception();
        }
        if (carName.isEmpty()) {
            throwMinLength_Exception();
        }
    }
    //자동차 이름이 없으면 오류 호출
    private void throwMinLength_Exception() {
        throw new IllegalArgumentException("[ERROR] 자동차 이름은 0글자 이상이어야 합니다.");
    }
    //자동차 이름이 제한 길이 보다 길어서 오류 호출
    private void throwMaxLength_Exception() {
        throw new IllegalArgumentException("[ERROR] 자동차 이름은 " + CAR_NAME_LIMIT_MAX + "글자 이하여야 합니다.");
    }
    //자동차 이름에 공백 있는지 확인
    private void checkNotSpace(String carName) {
        if (carName.contains(SPACE)) {
            throwSpaceException();
        }
    }
    //자동차 이름에 공백이 있으면 오류 호출
    private void throwSpaceException() {
        throw new IllegalArgumentException("[ERROR] 자동차 이름안에는 공백이 있어서는 안됩니다.");
    }
    //시행 횟수 입력에 대한 확인
    public void checkInput_TrialNumber(String input) throws IllegalArgumentException {
        checkEmpty_TrialNumber(input);
        checkOnlyNumber_TrialNumber(input);
    }
    //시행 횟수가 숫자인지 확인 후 아니면 오류 호출
    private void checkOnlyNumber_TrialNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도할 횟수는 숫자여야 합니다.");
        }
    }
    //시행 횟수가 공백인지 확인 후 아니면 오류 호출
    private void checkEmpty_TrialNumber(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
    }








}