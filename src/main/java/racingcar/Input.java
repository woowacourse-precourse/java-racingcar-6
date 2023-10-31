package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    //차 이름(쉼표로 구분된 여러 이름) 입력받기
    public static String inputCarName(){
        String carNames = Console.readLine();
        return carNames;
    }

    //차 이름 유효성 검사
    public static void checkCarNameValidation(String carName) {
        Validator.validateCarName(carName);
    }

    //입력받은 차 이름 분리하기(쉼표로 구분하기)
    public static List<String> separateCarNameInput(String carNames){
        List<String> carList = new ArrayList<>();
        String[] carNamesArr = carNames.split(",");
        for(int i=0;i<carNamesArr.length;i++) {
            checkCarNameValidation(carNamesArr[i]);
            carList.add(carNamesArr[i]);
        }
        return carList;
    }

    //차 이동횟수 입력받기
    public static int inputMovingNumber() {
        String movingNumberStr = Console.readLine();
        checkNumberValidation(movingNumberStr);
        int movingNumber = Integer.parseInt(movingNumberStr);
        return movingNumber;
    }

    //차 이동횟수 유효성 검사
    public static void checkNumberValidation(String movingNumberStr) {
        Validator.valdateMovingNumber(movingNumberStr);
    }

}
