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
        checkTryNumber(input);
        int tryNumber = Integer.parseInt(input);
        return tryNumber;
    }

    public void checkTryNumber(String input){
        if(input.equals("0")){
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) < '0' || input.charAt(i) > '9'){
                throw new IllegalArgumentException();
            }
        }
    }
}
