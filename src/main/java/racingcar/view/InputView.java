package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;

public class InputView {
    private int roundNumber;
    public static Map<String,Integer> inputCarNameView(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        Map<String,Integer> input = new HashMap<>();
        String str = Console.readLine();
        String[] arrStr = str.split(",");

        for(int i=0; i<arrStr.length; i++){
            input.put(arrStr[i],0);
        }
        return input;
    }
    public int inputRoundNumber(){
        System.out.println("시도할 횟수는 몇번인가요?");

        roundNumber = Integer.parseInt(Console.readLine());
        return roundNumber;
    }
}
