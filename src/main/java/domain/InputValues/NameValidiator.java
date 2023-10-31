package domain.InputValues;

import java.util.Arrays;

public class NameValidiator {
    public static final int NAME_MAX_SIZE =5;
    NameValidiator(String inputCarNames)
    {
        checkEmpty(inputCarNames);
        checkEndDelimiter(inputCarNames);
    }

    private void checkEndDelimiter(String inputCarNames){
        if(inputCarNames.charAt(inputCarNames.length()-1)==',')
        {
            throw new IllegalArgumentException("입력값이 쉼표로 끝납니다.");
        }
    }
    private void checkEmpty(String inputCarNames){
        if(inputCarNames.isEmpty()){
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }
    public void checkDuplicate(String []  inputCarNamesArray){
        if(inputCarNamesArray.length != Arrays.stream(inputCarNamesArray).distinct().count()){
            throw new IllegalArgumentException("중복되는 이름이 존재합니다.");
        }
    }

    public void checkEmptyorLongNames(String [] inputCarNamesArray){
        for(String carNames: inputCarNamesArray){
            if(carNames.isEmpty() || carNames.length()>NAME_MAX_SIZE){
                throw new IllegalArgumentException("이름이 너무 길거나 없습니다.");
            }
        }


    }

}
