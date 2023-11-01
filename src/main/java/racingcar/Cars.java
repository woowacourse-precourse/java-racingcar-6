package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final String[] carNames;
    private int firstMagicNumber = 0;
    private int lastMagicNumber = 9;

    public Cars() {
        String carNames = Console.readLine();
        nameLengthError(carNames);
        emptyError(carNames);
        this.carNames = carNames.split(",");
    }
    public void nameLengthError(String carNames){  //길이가 5글자 이상일 때
        String[] carNamesArray = carNames.split(",");
        for (String oneCarName : carNamesArray) {
            if (oneCarName.length() > 5) {
                throw new IllegalArgumentException(ExceptionError.nameLengthError);
            }
        }
    }

    public void emptyError(String carNames){ // 공백을 입력했을 때
        String[] carNameArray = carNames.split(",");
        for (String oneCarName : carNameArray) {
            if (oneCarName.trim().isEmpty()) {
                throw new IllegalArgumentException(ExceptionError.emptyError);
            }
        }
    }

    public int randomNumber(){
        return Randoms.pickNumberInRange(firstMagicNumber,lastMagicNumber);
    }

    public void moveCar() {
        for (int i = 0; i < carNames.length; i++) {

            if (randomNumber() > 3) {     //3보다 크면 -를 추가
                carNames[i] += "-";     //car의 이름이 하나의 배열을 가지고 있고 그 배열에서 추가
            }
        }
    }
}