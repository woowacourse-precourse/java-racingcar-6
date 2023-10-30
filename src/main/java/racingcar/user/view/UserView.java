package racingcar.manager.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class ManagerView {
    private static String CAR_NAME_SEPARATOR = ",";
    private static String NOT_SEPARATOR_IN_CAR_NAME = "','를 구분자로 입력해주세요.";
    private final Validation validation = new Validation();
    public void printStartMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public List<String> inputCarNames(){
        String CarNamesInput = Console.readLine();
        List<String> carNamesList = inputToCarList(CarNamesInput);

        if(validation.isDuplicated(carNamesList)){

        }


    }

    public List<String> inputToCarList(String CarNamesInput){
        if(validation.isNotSeparator(CarNamesInput)){
            throw new IllegalArgumentException(NOT_SEPARATOR_IN_CAR_NAME);
        }
        return List.of(CarNamesInput.split(CAR_NAME_SEPARATOR));
    }

}
