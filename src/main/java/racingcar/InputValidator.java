package racingcar;

public class InputValidator {

    public void validateLength(String data, int limitLength){
        if(data.length() > limitLength){
            throw new IllegalArgumentException("제한 길이를 초과하였습니다.");
        }
    }

    public void validateNull(String data){
        if(data.equals("") || data == null){
            throw new IllegalArgumentException("입력하지 않았습니다.");
        }
    }
}
