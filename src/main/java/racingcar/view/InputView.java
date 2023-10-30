package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.utils.InputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private final InputValidator inputValidator;
    public InputView(){
        inputValidator = new InputValidator();
    }
    public void inputName(List<Car> cars){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        if(!inputValidator.isNotNullValid(input)){
            throw new IllegalArgumentException("Input Error: Car Name is Null");
        }
        List<String> parseResults = parseNamesFromInput(input);
        if(!inputValidator.validateNumberOfCar(parseResults)){
            throw new IllegalArgumentException("Input Error: Invalid the minimum number of cars");
        }
        for(String result : parseResults){
            if(!inputValidator.isNoSpaceValid(result)){
                throw new IllegalArgumentException("Input Error: Invalid space condition");
            }
            if(!inputValidator.validateNameOfLength(result)){
                throw new IllegalArgumentException("Input Error: Invalid name length");
            }
            Car racer = new Car(result);
            cars.add(racer);
        }
    }
    public Integer inputMoveCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        System.out.println("여기2222!");
        String input = Console.readLine();
        System.out.println("여기!!" + inputValidator.isNotNullValid(input));
        if(!inputValidator.isNotNullValid(input)){
            throw new IllegalArgumentException("Input Error: moveCount is Null");
        }
        if(!inputValidator.isNumericValid(input)) {
            throw new IllegalArgumentException("Input Error: moveCount is not numeric");
        }
        Integer numericInput = Integer.parseInt(input);
        if(!inputValidator.isMinValueValid(numericInput)){
            throw new IllegalArgumentException("Input Error: Invalid the minimum number of moveCount");
        }
        return numericInput;
    }
    private List<String> parseNamesFromInput(String input){
        String[] parseResultArray = input.split(",", -1);
        // convert array type into list type
        return new ArrayList<>(Arrays.asList(parseResultArray));
    }
}
