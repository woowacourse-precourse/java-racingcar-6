package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputValue{
    public String[] getInputValue(){
        String[] inputValue = Console.readLine().strip().split("\\s*,\\s*");
        for (int i=0; i<inputValue.length; i++){
            if (inputValue[i].length() >= 5){
                throw new IllegalArgumentException();
            }
        }
        return inputValue;
    }
    public Integer getInputTime(){
        Integer inputTime = Integer.valueOf(Console.readLine());
        return inputTime;
    }
}