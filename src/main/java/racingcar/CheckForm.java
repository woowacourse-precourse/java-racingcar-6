package racingcar;

public class CheckForm {

    void InputForm(String input) {

        boolean CheckDelimiter = input.matches(".*[^,\\p{L}\\p{S}].*");

        if(CheckDelimiter){
            throw new IllegalArgumentException("ERROR: 자동차의 이름은 공백없이 ,를 이용하여 입력해주세요.");
        }

    }

    void RunnerSize(String runner){

        if(runner.length()>5){
            throw new IllegalArgumentException("ERROR: 자동차의 이름은 5글자를 초과해서는 안됩니다.");
        }

    }



}
