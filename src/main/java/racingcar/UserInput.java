package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInput {
    int tries = 0;
    public List<String> carNames = new ArrayList<>();
    public void receiveUserInput() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String namesInput = Console.readLine();
        String[] carNamesArray = namesInput.split(",");
        carNames = new ArrayList<>(Arrays.asList(carNamesArray));

        handleException();

        System.out.println("시도할 회수는 몇회인가요?");
        String triesInput = Console.readLine();
        tries =  Integer.parseInt(triesInput);
    }
    public void handleException(){

        for(int i = 0; i < carNames.size(); i++ ){
            String name = carNames.get(i).replace(" ","");
            if(name.length() > 5) {
                throw new IllegalArgumentException("String index out of range: 5");
            }
            carNames.set(i, name);


        }
    }

}
