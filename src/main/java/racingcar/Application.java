package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class Application {

    static private List<String> cars;
    static private int gameCount;

    // 랜던 숫자 생성기
    static int generateRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }

    // 자동차 이름 분류하기
    static void splitCarName(String input){
        cars = Arrays.asList("pobi","jason");
    }

    // n 대의 자동차 입력하기 - 사용자
    static void inputCarName(){
        String input = Console.readLine();
        splitCarName(input);
    }

    // 전질할 횟수 입력하기 - 사용자
    static void inputGameCount(){
        gameCount = Integer.parseInt(Console.readLine());
    }

    // 무작위 값이 4보다 큰지 확인하기
//    static Boolean checkForward(int value){
//        if(value >= 4){
//
//        }
//    }

    public static void main(String[] args) {
        System.out.println(generateRandomNumber());
    }
}
