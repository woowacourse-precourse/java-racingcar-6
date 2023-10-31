package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class Input {
    public static ArrayList<String> inputUser(){
        String[] userSplit;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String users = Console.readLine();

        userSplit = users.split(",");
        // 문자열을 , 로 구분

        for (String element : userSplit) {
            if (element.length() > 5){
                throw  new IllegalArgumentException();
            }
        }
        //오류 처리

        ArrayList<String>userArray = new ArrayList<String>(Arrays.asList(userSplit));
        // 자른 문자열을 ArrayList에 저장

        return userArray;
    }

}
