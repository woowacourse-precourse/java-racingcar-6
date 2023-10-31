package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {


    private static final String CARS_NAME_INPUT_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT_GUIDE ="";

    public String getCarsName(){
        System.out.println(CARS_NAME_INPUT_GUIDE);
        String carsName = Console.readLine();

        return carsName;
    }


    public Integer getTryCount(){return null;}
    private void checkCarsNameValidation(String carsName){}
    private void checkTryCountValidation(String tryCount){}
}
