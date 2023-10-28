package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }

    /**
     *  user의 차이름 입력을 받아서 유효한 값인지 확인하고 String[]로 각 유저의 이름을 쪼개서 리턴
     * @param users
     * @return String[] carNames
     */
    private static String[] checkCarName(String users){
        String[] carNames = users.split(",");
        for (String name : carNames) {
            if (name.trim().isEmpty()){
                throw new IllegalArgumentException("정확한 이름을 입력해주세요");
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
            }
        }
        return carNames;
    }

    /**
     * String[] 변환 된 유저의 차이름 입력에 " : " 기호 추가
     * @param carName
     * @return String[] carName
     */
    private static String[] setCarName(String[] carName){
        int numberOfCar = carName.length;
        for (int i = 0; i < numberOfCar; i++){
            carName[i] += " : ";
        }
        return carName;
    }

    /**
     * 유저의 시도 횟수 입력을 받아서 유효한 값인지 확인하고 parseInt()를 사용해 int로 변환 후 리턴
     * @param tryCount
     * @return int tries
     */
    private static int checkTries(String tryCount){
        int tries = 0;
        try {
            tries = parseInt(tryCount);
        } catch (Exception e){
            throw new IllegalArgumentException("유효한 숫자를 입력하세요");
        }
        return tries;
    }

    /**
     * 1~9까지 랜덤한 숫자를 생성해 4이상이면 전진 가능 true 리턴 아니면 false 리턴
     * @return boolean
     */
    private static boolean isForwardPossible(){
        int i = Randoms.pickNumberInRange(0,9);
        if (i >= 4){
            return true;
        }
        else {
            return false;
        }
    }
}
