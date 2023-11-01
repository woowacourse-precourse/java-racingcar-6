package racingcar;

import java.util.List;

public class Exceptions {

    public static void nameListInputException(String list){
        if(list.length() < 1){
            throw new IllegalArgumentException();
        }
    }

    public static void nameLengthException(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException();
        }
    }

    public static void notInputNaturalNumberException(String loop){
        try{
            Integer.parseInt(loop);
        } catch (IllegalArgumentException e){
            System.out.println("숫자만 입력하세요.");
        }
    }
}
