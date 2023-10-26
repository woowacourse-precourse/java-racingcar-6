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

    public static int inputCountNum() { // checkInput 구현시 수정 필요
        System.out.println("시도 횟수를 입력해 주세요!");
        String inputStr = Console.readLine();
        int count = Integer.parseInt(inputStr);
        return count;
    }

    public static List<Integer> getRandomNumList(int count){
        List<Integer> ranNumList = new ArrayList<>();
        for(int i=0; i<count; i++){
            int ranNum = Randoms.pickNumberInRange(0,9);
            ranNumList.add(ranNum);
        }
        return ranNumList;
    }

//    전진이면 1을 반환, 정지면 0을 반환
    public static int forwardOrStop(int ranNum){
        if(ranNum >= 4){
            return 1;
        }else {
            return 0;
        }
    }


    public static void main(String[] args) {
    }
}
