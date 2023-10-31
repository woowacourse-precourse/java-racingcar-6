package racingcar.manager.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class CarView {
    private static String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static String CAR_NAME_SEPARATOR = ",";
    private static String DUPLICATION_OF_CAR_NAME = "차 이름이 중복되었습니다.";
    private static String OVERSIZE_OF_CAR_NAME = "차 이름이 5글자가 초과되었습니다.";
    private final CarViewValidation carViewValidation = new CarViewValidation();

    public CarView(){
        printStartMessage();
    }
    public void printStartMessage(){
        System.out.println(START_MESSAGE);
    }

    public List<String> inputCarNames(){
        String CarNamesInput = Console.readLine();
        List<String> carNamesList = inputToCarList(CarNamesInput);

        if(carViewValidation.isDuplicated(carNamesList)){
            throw new IllegalArgumentException(DUPLICATION_OF_CAR_NAME);
        }

        if(carViewValidation.greaterThanFiveLetter(carNamesList)){
            throw new IllegalArgumentException(OVERSIZE_OF_CAR_NAME);
        }

        return carNamesList;

    }

    public List<String> inputToCarList(String CarNamesInput){
        return List.of(CarNamesInput.split(CAR_NAME_SEPARATOR));
    }

}
