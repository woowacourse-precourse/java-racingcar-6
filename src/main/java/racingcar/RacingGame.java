package racingcar;

import java.util.regex.Pattern;

public class RacingGame {
    public static final String COMMA=",";
    public static final int NAME_MAX_LENGTH=5;
    public static final int NAME_EMPTY_SIZE=0;

    private static final Pattern INTEGER=Pattern.compile("[0-9]+");

    public RacingGame(){

    }

    public String[] splitNames(String names){
        return names.split(COMMA);
    }

    private void checkNameCorrectRange(String name){
        if(name.length()>NAME_MAX_LENGTH){
            throw new IllegalArgumentException("이름이 5자를 초과했습니다. 초과이름: "+name);
        }
    }

    private String removeWhiteSpace(String name){
        return name.replace(" ","");
    }

    private void checkNameIsEmpty(String name){
        if(name.length()==NAME_EMPTY_SIZE){
            throw new IllegalArgumentException("비어있는 이름이 들어왔습니다.");
        }
    }

    public void checkAttemptCountIsInteger(String input){
        if(!INTEGER.matcher(input).matches()){
            throw new IllegalArgumentException("정수를 입력해야합니다.");
        }
    }

    public void validateName(String name){
        String nameWithoutWhiteSpace=removeWhiteSpace(name);
        checkNameIsEmpty(nameWithoutWhiteSpace);
        checkNameCorrectRange(nameWithoutWhiteSpace);
    }
}
