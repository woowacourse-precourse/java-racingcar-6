package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final InputValidator inputValidator = new InputValidator();

    public String[] readRacingCarName(){
        String[] racingCarNames = toStringArray(Console.readLine());

        inputValidator.validateRacingCarNameLength(racingCarNames);

        return racingCarNames;
    }

    public int readNumberOfTry(){
        String input = Console.readLine();

        inputValidator.validateNumberTypeOfTry(input);

        int numberOfTry = toInt(input);
        inputValidator.validateNumberRangeOfTry(numberOfTry);

        return numberOfTry;
    }

    private int toInt(String str){
        return Integer.parseInt(str);
    }

    private String[] toStringArray(String str){
        return str.split(",");
    }
}
