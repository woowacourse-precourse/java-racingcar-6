package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {
    private final static int MIN_CAR_NUM = 2;

    public void checkCarNameInputForm(String carNameInput) {
        if (!isIdentifierComma(carNameInput)) {
            throw new IllegalArgumentException("입력 구분을 ,로 하지 않았습니다.");
        }
    }

    private boolean isIdentifierComma(String carNameInput){
        String regex = "([0-9a-zA-Zㄱ-ㅎ가-힣]+,)*[0-9a-zA-Zㄱ-ㅎ가-힣]+";
        return carNameInput.matches(regex);
    }

    public void checkCarNameForm(String carName){
        if(!isCarNameLength(carName)) {
            throw new IllegalArgumentException("자동차 이름은 길이는 5이하 입니다.");
        }
    }

    private boolean isCarNameLength(String carName) {
        return 0 < carName.length() && carName.length() <= 5;
    }

    public void checkDuplicateCarName(List<String> carNameList){
        if(isDuplicateCarName(carNameList)) {
            throw new IllegalArgumentException("차 이름이 중복됐습니다.");
        }
    }

    private boolean isDuplicateCarName(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);
        return carNameSet.size() != carNameList.size();
    }

    public void checkCarNum(List<String> carNameList){
        if(!isCarMoreThanOne(carNameList)) {
            throw new IllegalArgumentException("차는 2대 이상 이여야 경주가 가능합니다.");
        }
    }


    private boolean isCarMoreThanOne(List<String> carNameList) {
        return carNameList.size() >= MIN_CAR_NUM;
    }

    private boolean isTryNumInteger(String tryNum) {
        try {
            Integer.parseInt(tryNum);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private boolean isTryNumPositiveNum(int tryNum) {
        return tryNum > 0;
    }
}
