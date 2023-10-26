package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {

    public static List<String> inputCarName() {  // checkInput 구현시 수정 필요
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputStr = Console.readLine();
        inputStr = inputStr.replace(" ", "");
        String[] inputArr = inputStr.split(",");
        List<String> nameList = Arrays.asList(inputArr);
        return nameList;
    }

    public static int inputCountNum() { // checkInput 구현시 수정 필요
        System.out.println("시도할 회수는 몇회인가요?");
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

    public static Map<String, Integer> sumAllForward(String name, List<Integer> ranNumList){
        int sumForward = 0;
        for(int i=0; i<ranNumList.size(); i++){
            sumForward += forwardOrStop(ranNumList.get(i));
        }
        Map<String, Integer> forwardDistance = new HashMap<>();
        forwardDistance.put(name, sumForward);
        return forwardDistance;
    }



    public static void main(String[] args) {
    }
}
