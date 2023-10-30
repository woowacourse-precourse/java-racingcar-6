package racingcar.validator;

import static racingcar.util.ErrorMessage.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private final static int MIN_CAR_NUM = 2;

    public void checkCarNameInputForm(String carNameInput) {
        if (!isIdentifierComma(carNameInput)) {
            throw new IllegalArgumentException(COMMA_IDENTIFIER_ERROR_MESSAGE.getMessage());
        }
    }

    private boolean isIdentifierComma(String carNameInput){
        String regex = "([0-9a-zA-Zㄱ-ㅎ가-힣]+,)*[0-9a-zA-Zㄱ-ㅎ가-힣]+";
        return carNameInput.matches(regex);
    }

    public void checkCarNameForm(String carName){
        if(!isCarNameLength(carName)) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE.getMessage());
        }
    }

    private boolean isCarNameLength(String carName) {
        return 0 < carName.length() && carName.length() <= 5;
    }

    public void checkDuplicateCarName(List<String> carNameList){
        if(isDuplicateCarName(carNameList)) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME_ERROR_MESSAGE.getMessage());
        }
    }

    private boolean isDuplicateCarName(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);
        return carNameSet.size() != carNameList.size();
    }

    public void checkCarNum(List<String> carNameList){
        if(!isCarMoreThanOne(carNameList)) {
            throw new IllegalArgumentException(CAR_NUM_ERROR_MESSAGE.getMessage());
        }
    }


    private boolean isCarMoreThanOne(List<String> carNameList) {
        return carNameList.size() >= MIN_CAR_NUM;
    }

    public void checkTryNumType(String tryNum) {
        if (!isTryNumInteger(tryNum)) {
            throw new IllegalArgumentException(TRY_NUM_TYPE_ERROR_MESSAGE.getMessage());
        }
    }

    private boolean isTryNumInteger(String tryNum) {
        try {
            Integer.parseInt(tryNum);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public void checkTryNum(int tryNum) {
        if (!isTryNumPositiveNum(tryNum)) {
            throw new IllegalArgumentException(TRY_NUM_RANGE_ERROR_MESSAGE.getMessage());
        }
    }

    private boolean isTryNumPositiveNum(int tryNum) {
        return tryNum > 0;
    }
}
