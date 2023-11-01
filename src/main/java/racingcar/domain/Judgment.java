package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Judgment {

    public static boolean isOverFourDistance(int distance){
        return distance >= 4;
    }

    public static String isOverFiveLength(String name){
       if(name.length() > 5 || name.length() < 1)
           throw new IllegalArgumentException("잘못된 길이의 이름이 입력됨 : "+ name);
       return name;
    }

    public static int checkInteger(String strValue) {
        try {
            return Integer.parseInt(strValue);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("잘못된 값 입력 : " + strValue);
        }
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
