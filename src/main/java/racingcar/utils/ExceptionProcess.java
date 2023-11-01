package racingcar.utils;

import java.util.ArrayList;
import java.util.List;

public class ExceptionProcess {

    public void carNameEnterException(String carName) {
        // 자동차를 문자로 입력하지 않은 경우
        notStringInput(carName);
        // 문자열 길이가 5자 이상일 경
        excessiveLength(carName);
        // 자동차를 중복으로 입력한 경우
        duplicateEntry(carName);
        // 자동차 입력시 쉼표를 제외하고 입력한 경우
        noComma(carName);
    }

    public void numberTryEnterException(String numberTry) {
        // 이동횟수에 숫자가 아닌 경우
        notIntInput(numberTry);
        // 이동횟수에 0을 입력한 경우
        zeroInput(numberTry);
    }

    public void duplicateEntry(String carName) {
        String[] carNameArray = carName.split(",");
        List<String> carNameList = new ArrayList<>();

        for(String car : carNameArray) {
            if(!carNameList.contains(car)) {
                carNameList.add(car);
            }else {
                throw new IllegalArgumentException("입력된 자동차 이름에 중복이 존재합니다.");
            }
        }
    }

    public void excessiveLength(String carName) {
        String[] carNameArray = carName.split(",");

        for(String car : carNameArray) {
            if(car.length() > 5) {
                throw new IllegalArgumentException("입력된 자동차 이름 길이가 초과되었습니다.");
            }
        }
    }

    public void noComma(String carName) {
        String[] carNameArray = carName.split(",");
        if(carNameArray.length > 1) {
            if(!carName.contains(",")) {
                throw new IllegalArgumentException("이름을 쉼표로 구분해주세요.");
            }
        }
    }

    public void notStringInput(String carName) {
        for (char c : carName.toCharArray()) {
            if(c != ','){
                if (Character.isDigit(c)) {
                    throw new IllegalArgumentException("이름은 숫자가 포함되어 있으면 안됩니다.");
                }
            }
        }
    }

    public void zeroInput(String numberTry) {
        int numberTryInt = Integer.parseInt(numberTry);
        if(numberTryInt == 0) {
            throw new IllegalArgumentException("유효한 값을 입력해주세요.");
        }
    }

    public void notIntInput(String numberTry) {
        try {
            Integer.parseInt(numberTry);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
