package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {


    private static final String CARS_NAME_INPUT_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT_GUIDE ="시도할 회수는 몇회인가요?";

    public String getCarsName(){
        System.out.println(CARS_NAME_INPUT_GUIDE);
        String carsName = Console.readLine();
        checkCarsNameValidation(carsName);

        return carsName;
    }


    public Integer getTryCount(){
        System.out.println(TRY_COUNT_INPUT_GUIDE);
        String userInput = Console.readLine();

        Integer tryCount = Integer.parseInt(userInput);

        return tryCount;
    }
    private void checkCarsNameValidation(String carsName){
        checkInputIsBlank(carsName);
        checkCarsNameLength(carsName);
    }

    private void checkInputIsBlank(String input){
        if(input.isBlank()){
            throw new IllegalArgumentException();
        }
    }

    private void checkCarsNameLength(String carsName){

        List<String> carNames = Arrays.asList(carsName.split(","));

        for(String carName : carNames){
            if(carName.length() >= 6){
                throw new IllegalArgumentException();
            }
            else if(carName.isEmpty()){
                throw new IllegalArgumentException();
            }
        }
    }


    private void checkTryCountValidation(String tryCount){

    }


}
