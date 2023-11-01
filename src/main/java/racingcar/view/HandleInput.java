package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.global.message.GameProgressMessage;

import java.util.Arrays;
import java.util.List;

public class HandleInput {

    public List<String> inputCarNames(){
        GameProgressMessage.CAR_NAMES_INPUT_MESSAGE.printMessage();
        String userInput = Console.readLine();

        InputValidator.isInputValid(userInput);
        List<String> carNames = parseByComma(userInput);

        for(String carName : carNames){
            InputValidator.isFiveLettersOver(carName);
        }
        return carNames;
    }

    public int inputTryNumber(){
        GameProgressMessage.TRY_NUMBER_INPUT_MESSAGE.printMessage();
        String userInput = Console.readLine();

        InputValidator.isInputValid(userInput);
        InputValidator.isInputDigit(userInput);

        return Integer.parseInt(userInput);
    }

    private List<String> parseByComma(String input){
        List<String> parsedList = Arrays.stream(input.split(",")).map(String::trim).toList();
        InputValidator.isListEmpty(parsedList);
        parsedList.forEach(InputValidator::isInputValid);

        return parsedList;
    }

}
