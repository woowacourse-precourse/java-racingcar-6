package racingcar;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    static LinkedHashMap<String, Integer> carsMap = new LinkedHashMap<>();
    static int count;
    private static int getRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }

    private static boolean isForward(){
        int number = getRandomNumber();
        if(number>=4)
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }
}
