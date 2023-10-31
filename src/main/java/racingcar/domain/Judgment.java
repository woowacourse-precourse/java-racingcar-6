package racingcar.domain;

public class Judgment {

    public static boolean isOverFourDistance(int distance){
        return distance >= 4;
    }

    public static void isOverFiveLength(String name){
       if(name.length() > 5)
           throw new IllegalArgumentException("이름의 길이가 5를 넘었습니다 : "+ name);

    }

}
