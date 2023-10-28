package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Racing {
    private Racing(){

    }
    public List<String> getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = Arrays.asList(Console.readLine().split(","));
        checkNameLength(carNames);

        return carNames;
    }
    private int checkNameLength(List<String> carNames){
        for(int i=0;i<carNames.size();i++){
            if(carNames.get(i).length()>5) {
                throw new IllegalArgumentException("each racing car's name must be shorter than 6");
            }
        }
        return 0;

    }
}
