package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {


    private static final String CARS_NAME_INPUT_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT_GUIDE ="시도할 회수는 몇회인가요?";

    public String getCarsName(){
        System.out.println(CARS_NAME_INPUT_GUIDE);
        String carsName = Console.readLine();

        return carsName;
    }


    public Integer getTryCount(){
        System.out.println(TRY_COUNT_INPUT_GUIDE);
        String userInput = Console.readLine();

        Integer tryCount = Integer.parseInt(userInput);

        return tryCount;
    }
    private void checkCarsNameValidation(String carsName){}
    private void checkTryCountValidation(String tryCount){}
}
