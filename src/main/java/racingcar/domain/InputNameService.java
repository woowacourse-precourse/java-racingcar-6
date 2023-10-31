package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class InputNameService {
    private final static String partition = ",";
    private final static String exceptionMessage = "경주할 자동차 이름이 올바르게 입력되지 않았습니다.";
    public List<String> nameList; // 테스트를 위해서 잠시 public
    public InputNameService(){
        InputName inputName = new InputName();
        String input = inputName.getInput();

        nameList = new ArrayList<>();
        convertStrToList(input);
    }

    private void convertStrToList(String str){
        String[] splited = str.split(partition);
        for(String s: splited){
            if(s==null) checkException();
            if(s.equals(" ")) checkException();
            if(s.length()>5) checkException();
            nameList.add(s);
        }
    }

    private void checkException(){
        throw new IllegalArgumentException(exceptionMessage);
    }

}
