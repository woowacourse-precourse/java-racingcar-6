package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.Printer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputDevice {
    public String[] inputCarNames(){
        String inputValue = Console.readLine();
        String[] splitInputValue = inputValue.split(",");
        for(String carName : splitInputValue){
            checkCarNameLength(carName);
            checkFirstWhiteSpace(carName);
        }
        return splitInputValue;
    }


    private void checkCarNameLength(String carName){
        if(!(0 < carName.length() && (carName.length() <= 5))){
            throw new IllegalArgumentException(Printer.ERROR_CAR_NAME_LENGTH);
        }
    }

    private void checkFirstWhiteSpace(String carName){
        if(carName.startsWith(" ")){
            throw new IllegalArgumentException(Printer.ERROR_CAR_NAME_FIRST_WHITE_SPACE);
        }
    }

    public Integer inputTryNumber(){
        String inputValue = Console.readLine();
        checkTryNumber(inputValue);
        return Integer.valueOf(inputValue);
    }

    private void checkTryNumber(String tryNumber){
        String regex = "^[1-9]\\d*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(tryNumber);
        if(!matcher.matches()){
            throw new IllegalArgumentException("시도 횟수는 자연수로 입력해야 합니다.");
        }
    }
}
