package racingcar.Service;

import java.util.Arrays;
import java.util.List;

public class Validation {
    private static final String DISTINGUISH_ERROR_MESSAGE = "이름을 쉼표(,)로 구분할 수 없습니다.";
    private static final String EXCEED_ERROR_MESSAGE = "최대 이름 글자수를 초과하였습니다.";
    private static final int MAX_SPELLING_COUNT = 5;

    public void checkCarNamesValidation(String inputCarNames){

        if(!isSplitValue(inputCarNames)){
            throw new IllegalArgumentException(DISTINGUISH_ERROR_MESSAGE);
        }
        if(!NumberOfNameSpelling(inputCarNames)){
            throw new IllegalArgumentException(EXCEED_ERROR_MESSAGE);
        }
    }

    private boolean isSplitValue(String name) {
        try{
            List<String> carNames = Arrays.stream(name.split(",")).toList();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    private boolean NumberOfNameSpelling(String name) {
        List<String> carNames = Arrays.stream(name.split(",")).toList();
        for(int i=0;i < carNames.size();i++){
            if((carNames.get(i)).length() > MAX_SPELLING_COUNT){
                return false;
            }
        }
        return true;
    }
}
