package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Readline {
    public List<String> Readinput(){
        List<String> members = new ArrayList<>();
        String input = Console.readLine();
        for(String SplitInput : input.split(",")){
            if(SplitInput.length() > 5){
                throw new IllegalArgumentException("자동차의 이름이 5글자가 넘었습니다.");
            }
            members.add(SplitInput);
        }
        return members;
    }
}
