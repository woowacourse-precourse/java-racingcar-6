package racingcar;

import java.util.List;

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

    void CountForm(String countInput) {
        int count = Integer.parseInt(countInput);

        if(count <= 0){
            throw new IllegalArgumentException("ERROR: 반복 횟수는 양의 정수여야 합니다.");
        }
    }

    void isSingleCar(List<String> RunnerMap) {
        if(RunnerMap.size()==1){
            throw new IllegalArgumentException("ERROR: 차는 최소 2대 이상을 입력해주세요.");
        }
    }

}
