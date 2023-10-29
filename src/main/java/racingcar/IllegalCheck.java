package racingcar;

import java.util.Optional;

public class IllegalCheck {

    static final int INPUT_RANGE_MIN = 0;
    static final int INPUT_RANGE_MAX = Integer.MIN_VALUE;
    private String inputLine;
    private ConvertType type;
    private boolean flag = false;
    public Optional<String> needConvertInteger(String inputLine){
        this.inputLine = inputLine;
        this.type = ConvertType.INTEGER;
        this.flag = false;

        characterCheck();

        if(isSuccess()){
            return Optional.ofNullable(inputLine);
        }

        return Optional.ofNullable(null);
    }

    private void characterCheck(){
        if(flag){
            return;
        }
        flag = inputLine.chars()
                .allMatch(Character::isDigit);
    }

    private boolean isSuccess(){
        return flag;
    }
}
