package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class User {
    public List<String> inputCar() {
        String input = Console.readLine();
        List<String> carName = Arrays.asList(input.split(","));
        checkInputCar(carName);
        return carName;
    }

    public void checkInputCar(List<String> carName){
        HashSet<String> DuplicateName = new HashSet<>();
        DuplicateName.addAll(carName);
        if(carName.size() != DuplicateName.size()){
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < carName.size(); i++){
            if(carName.get(i).length() > 5){
                throw new IllegalArgumentException();
            }
        }
    }

    public int inputTryNumber(){
        String input = Console.readLine();
        int tryNumber = checkTryNumber(input);
        checkNegativeNumber(tryNumber);
        return tryNumber;
    }

    public int checkTryNumber(String input){
        int inputNumber;
        try{
            inputNumber = Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("잘못된 숫자를 입력하였습니다.");
        }
        return inputNumber;
    }

    public void checkNegativeNumber(int tryNumber){
        if(tryNumber < 1){
            throw new IllegalArgumentException("잘못된 숫자를 입력하셨습니다.");
        }
    }
}
