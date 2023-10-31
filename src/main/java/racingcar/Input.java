package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    public List<String> carNameInput(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesWithComma = Console.readLine();

        List<String> carNames = carNameSplit(carNamesWithComma);
        return carNames;
    }

    public List<String> carNameSplit(String carNamesWithComma){
        List<String> carNames = new ArrayList<>();
        String[] carName = carNamesWithComma.split(",");
        for(int i=0; i<carName.length; i++){
            if(carName[i].length() > 5) {
                throw new IllegalArgumentException("자동차 이름이 5자 초과함");
            }
            carNames.add(carName[i]);
        }
        return carNames;
    }

    public int roundNumInput(){
        System.out.println("시도할 회수는 몇회인가요?");
        String num = Console.readLine();
        int round = Integer.parseInt(num);
        return round;
    }


}
