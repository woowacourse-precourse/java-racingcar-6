package racingcar.exception;

import java.util.Arrays;
import java.util.List;
import static racingcar.Config.*;

public class InputException {
    public InputException() {
    }

    private static class LazyHolder {
        public static final InputException instance = new InputException();
    }
    public static InputException getinstance(){
        return LazyHolder.instance;
    }

    public List<String> carListException(String input){
        checkInputIsNull(input);
        String[] values = input.split(",");

// 배열을 리스트로 변환
        List<String> carList = Arrays.asList(values);
        for(String car:carList){
            car = car.trim();
            carNameSizeException(car);
        }
        carListSizeException(carList);


        return carList;
    }

    public void checkInputIsNull(String input){
        if(input==""){
            throw new IllegalArgumentException("자동차 이름을 입력하여야 합니다.");
        }
        return;
    }

    public List<String> carListSizeException(List<String> carList){
        if (carList.size() >0) {
            return carList;
        } else {
            throw new IllegalArgumentException("자동차는 1개 이상 있어야합니다.");
        }
    }

    public void carNameSizeException(String car){
        if(car.length()>Car_Name_LENGTH){
            throw new IllegalArgumentException("자동차의 이름은 중간 공백을 포함해 5글자 이하여야 합니다.");
        }
        return;
    }

    public int RoundException(String input){
        int numOfRound=formatOfRoundException(input);
        return numOfRoundException(numOfRound);
    }

    public int numOfRoundException(int input) {
        if(input<0){
            throw new IllegalArgumentException(Num_Of_Round_Exception);
        }
        return input;
    }

    public int formatOfRoundException(String input){
        input=input.trim();
        try {
            int numOfRound = Integer.parseInt(input);
            return numOfRound;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Format_Of_Round_Exception);
        }
    }


}
