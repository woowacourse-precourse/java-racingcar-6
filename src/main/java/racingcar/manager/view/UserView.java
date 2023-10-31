package racingcar.manager.view;

import camp.nextstep.edu.missionutils.Console;

public class UserView {
    private final UserViewValidation userViewValidation = new UserViewValidation();

    private static String USER_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static String NOT_DIGIT_MESSAGE = "숫자를 입력해주세요.";
    public void printUserInputMessage(){
        System.out.println(USER_INPUT_MESSAGE);
    }
    public Integer inputTryCount(){
        printUserInputMessage();
        String inputCount = Console.readLine();
        if(!userViewValidation.isDigit(inputCount)){
            throw new IllegalArgumentException(NOT_DIGIT_MESSAGE);
        }
        return stringToInt(inputCount);
    }

    public Integer stringToInt(String inputCount){
        return Integer.parseInt(inputCount);
    }
}
