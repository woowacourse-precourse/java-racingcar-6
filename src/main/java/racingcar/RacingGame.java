package racingcar;

public class RacingGame {
    public static final String COMMA=",";
    public static final int NAME_MAX_LENGTH=5;
    public static final int NAME_EMPTY_SIZE=0;
    public RacingGame(){

    }

    public String[] splitNames(String names){
        return names.split(COMMA);
    }

    public void checkNameCorrectRange(String name){
        if(name.length()>NAME_MAX_LENGTH){
            throw new IllegalArgumentException("이름이 5자를 초과했습니다. 초과이름: "+name);
        }
    }

    public String removeWhiteSpace(String name){
        return name.replace(" ","");
    }

    public void checkNameIsEmpty(String name){
        if(name.length()==NAME_EMPTY_SIZE){
            throw new IllegalArgumentException("비어있는 이름이 들어왔습니다.");
        }
    }
}
