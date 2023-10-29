package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RaceViewer {
    String[] getCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.");
        return Console.readLine().split(",");
    }

    public int nTimes(){
        System.out.println("시도할 횟수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public void printResult(String result){
        System.out.println(result);
    }

}
