package racingcar;

public class Validator {

    public void checkCarNamesInput(String input) throws IllegalArgumentException{
        checkEmpty(input);
        checkLastIndex(input);

    }

    private void checkEmpty(String input){
        if(input.isEmpty()){
            throw new IllegalArgumentException("값을 입력해주세요.");
        }
    }

    private void checkLastIndex(String input){
        if(input.lastIndexOf(",") == input.length() - 1){
            throw new IllegalArgumentException("자동차 이름은 0 글자 이상 입력해주세요");
        }
    }

}
