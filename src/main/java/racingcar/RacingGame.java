package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {

    public List<String> inputCarName() {  // checkInput 구현시 수정 필요
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputStr = Console.readLine();
        inputStr = inputStr.replace(" ", "");
        String[] inputArr = inputStr.split(",");
        List<String> nameList = Arrays.asList(inputArr);
        return nameList;
    }

    public int inputCountNum() { // checkInput 구현시 수정 필요
        System.out.println("시도할 회수는 몇회인가요?");
        String inputStr = Console.readLine();
        int count;
        try {
            count = Integer.parseInt(inputStr);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return count;
    }

    public int getRandomNum() {
        int ranNum = Randoms.pickNumberInRange(0, 9);
        return ranNum;
    }


    public int forwardOrStop(int ranNum) {// 전진이면 1을 반환, 정지면 0을 반환
        if (ranNum >= 4) {
            return 1;
        } else {
            return 0;
        }
    }
}
