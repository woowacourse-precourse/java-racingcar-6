package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static List<String> inputCarName() {  // checkInput 구현시 수정 필요
        System.out.println("참가자 이름을 입력해 주세요!");
        String inputStr = Console.readLine();
        inputStr = inputStr.replace(" ", "");
        String[] inputArr = inputStr.split(",");
        List<String> nameList = Arrays.asList(inputArr);
        return nameList;
    }

    public static void main(String[] args) {
    }
}
