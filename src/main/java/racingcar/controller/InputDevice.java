package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.Printer;

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

}
