package racingcar.service;

import java.util.List;
import java.util.regex.Pattern;

public class IoValidation {
    private boolean isFewCarNum(List<String> carNames){
        if(carNames.size()>1){
            return false;
        }
        return true;
    }

    private boolean isOutOfCarNameBound(List<String> carNames){
        return carNames.stream().
                anyMatch(carName->carName.length()>5);
    }

    public void validateCarNameInput(List<String> carNames){
        if(isFewCarNum(carNames)){
            throw new IllegalArgumentException("차는 한개 이상이어야 합니다.");
        }
        if(isOutOfCarNameBound(carNames)){
            throw new IllegalArgumentException("차의 이름은 5자 이하만 가능합니다.");
        }
    }

    public void validateTurnNumberInput(String string){
        if(!Pattern.matches("\\d+",string)){
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }
}
