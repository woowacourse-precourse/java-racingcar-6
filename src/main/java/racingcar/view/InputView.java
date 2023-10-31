package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;

public class InputView {
    public static Map<String,Integer> inputCarNameView(){
        Map<String,Integer> input = new HashMap<>();
        String str = Console.readLine();
        String[] arrStr = str.split(",");

        for(int i=0; i<arrStr.length; i++){
            input.put(arrStr[i],0);
        }
        return input;
    }
}
