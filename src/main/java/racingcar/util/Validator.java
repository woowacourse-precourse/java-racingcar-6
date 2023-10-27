package racingcar.util;


import java.util.List;

public class Validator {

    private static final int MAX_CAR_NAME_LENGTH = 5;


    //비어있지 않거나, 5이하일때
    public boolean isValidNameLength(String input){
        if (!input.isEmpty() && input.length() <= MAX_CAR_NAME_LENGTH) {
            return true;
        }
        throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
    }

    public boolean checkDuplicateName(List<String> carNameList){
        if(carNameList.size() != carNameList.stream().distinct().count()){
            throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        }
        return true;
    }

    //비어있지 않거나 숫자일때
    public boolean isValidTrialNumber(String input){
        if(!input.isEmpty() && isNumberDigit(input)){
            return true;
        }
        throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
    }

    public boolean isNumberDigit(String input) {
        for(char c : input.toCharArray()){
            if(!Character.isDigit(c) || c == '0'){
                throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
            }
        }
        return true;
    }


}
