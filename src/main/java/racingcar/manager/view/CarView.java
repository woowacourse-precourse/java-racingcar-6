package racingcar.manager.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class CarView {
    private static String CAR_NAME_SEPARATOR = ",";
    private static String NOT_SEPARATOR_IN_CAR_NAME = "','를 구분자로 입력해주세요.";
    private static String DUPLICATION_OF_CAR_NAME = "차 이름이 중복되었습니다.";
    private static String OVERSIZE_OF_CAR_NAME = "차 이름이 5글자가 초과되었습니다.";
    private final Validation validation = new Validation();
    public void printStartMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public CarView(){
        printStartMessage();
    }

    public List<String> inputCarNames(){
        String CarNamesInput = Console.readLine();
        List<String> carNamesList = inputToCarList(CarNamesInput);

        if(validation.isDuplicated(carNamesList)){
            throw new IllegalArgumentException(DUPLICATION_OF_CAR_NAME);
        }

        if(validation.greaterThanFiveLetter(carNamesList)){
            throw new IllegalArgumentException(OVERSIZE_OF_CAR_NAME);
        }

        return carNamesList;

    }

    public List<String> inputToCarList(String CarNamesInput){
        if(validation.isNotSeparator(CarNamesInput)){
            throw new IllegalArgumentException(NOT_SEPARATOR_IN_CAR_NAME);
        }
        return List.of(CarNamesInput.split(CAR_NAME_SEPARATOR));
    }

}
