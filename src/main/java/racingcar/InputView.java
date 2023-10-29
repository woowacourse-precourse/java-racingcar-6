package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.mockito.internal.matchers.Null;

public class InputView {

    String[] inputCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        validHasInput(cars);
        return makeInputArray(cars);
    }

    String[] makeInputArray(String cars){
        return cars.split(",");
    }

    int inputTrialNumber(){
        System.out.println("시도할 회수는 몇회인가요?");
        String stringNumber = Console.readLine();
        validHasInput(stringNumber);
        int number = validNumber(stringNumber);
        return number;
    }


    void validHasInput(String input){
        if(input == null){
            throw new IllegalArgumentException();
        }
    }

    int validNumber(String stringNumber) {
        int number;
        try {
            number = Integer.parseInt(stringNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        if (number < 1) {
            throw new IllegalArgumentException();
        }
        return number;
    }


}
