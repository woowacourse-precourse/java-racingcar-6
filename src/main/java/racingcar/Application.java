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
}
