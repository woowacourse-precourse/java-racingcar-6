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
        String[] values = input.split(",");

// 배열을 리스트로 변환
        List<String> carList = Arrays.asList(values);
        carListSizeException(carList);

        for(String car:carList){
            car = car.trim();
            carNameSize(car);
        }

        return carList;
    }

    public List<String> carListSizeException(List<String> carList){
        if (carList.size() >0) {
            return carList;
        } else {
            throw new IllegalArgumentException("자동차는 1개 이상 있어야합니다.");
        }
    }

    public void carNameSize(String car){
        if(car.length()>Car_Name_LENGTH){
            throw new IllegalArgumentException("자동차의 이름은 중간 공백을 포함해 5글자 이하여야 합니다.");
        }
        return;
    }


}
