package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String stringCarNames = Console.readLine();

        if(!checkCarNames(stringCarNames)) throw new IllegalArgumentException();


    }

    public static boolean checkCarNames(String stringCarNames) {

        if(!stringCarNames.contains(",")|| stringCarNames.contains(" ")) return false;

        String[] arrayCarNames = stringCarNames.split(",");

        for(int i=0;i<arrayCarNames.length;i++){
            if(arrayCarNames[i].length()>5) return false;
        }

        Set<String> set = new HashSet<>();
        for (String name : arrayCarNames) {
            set.add(name);
        }

        if (set.size() != arrayCarNames.length) return false;

        return true;
    }
}
