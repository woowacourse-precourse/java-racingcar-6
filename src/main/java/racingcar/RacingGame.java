package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {
    String[] carNameList;

    public void init(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarName = Console.readLine();
        carNameList = inputCarName.split(",");
        for(String s : carNameList){
            System.out.println(s);
        }
    }

}
