package racingcar.util;

import java.util.List;

public class Validator {

    public void size(List<String> nameList){
        for(String name:nameList){
            if(name.length()>5){
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다");
            }
        }
    }
    public void blank(List<String> nameList){
        for(String name:nameList){
            if(name.equals("")){
                throw new IllegalArgumentException("공백이나 ,은 불가합니다.");
            }
        }
    }
}
