package racingcar;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static final Integer CARNAME_MAXSIZE = 5;
    private static final Integer CARNAME_MINSIZE = 1;

    public List<String> carNames = new ArrayList<>();

    public void carNameSplit(String userInput){
        String[] carNameArray = userInput.split(",");

        for(String carName : carNameArray) {
            carNames.add(carName.trim());
        }
    }

    public void carNameVaildation(List<String> carNames){
        for(String carName : carNames){
            if(carName.length() > CARNAME_MAXSIZE){
                throw new IllegalArgumentException("입력한 이름은 5자 이하만 가능합니다.");
            }

            if(carName.length() < CARNAME_MINSIZE){
                throw new IllegalArgumentException("이름을 1자 이상 5자 이하로 입력해 주세요.");
            }
        }
    }

}
