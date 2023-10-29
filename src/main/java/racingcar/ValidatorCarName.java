package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidatorCarName {
    public List<String> carNameList = new ArrayList<String>();


    public ValidatorCarName() {
    }

    public void checkCarName(String carName) {
        isContainComma(carName);
        isCorrectNameLength(carName);
        isNotDuplicated(carName);
        isNameBlank(carName);

        this.carNameList = List.of(carName.split(","));
    }

    private void isContainComma(String carName) throws IllegalArgumentException {
        if(!carName.contains(",")){
            throw new IllegalArgumentException("comma기호 가 없습니다"+ carName);
        }
    }

    private void isCorrectNameLength(String carName) throws IllegalArgumentException {
        List<String> nameList = new ArrayList<String>(List.of(carName.split(",")));
        for (int i = 0; i < nameList.size(); i++) {
            if(nameList.get(i).length() > 5) {
                throw new IllegalArgumentException("이름의 길이는 5이하 입니다");
            }
        }
    }

    private void isNameBlank(String carName) {
        List<String> nameList = new ArrayList<String>(List.of(carName.split(",")));
        for (int i = 0; i < nameList.size(); i++) {
            if(nameList.get(i).isBlank()) {
                throw new IllegalArgumentException("공백인 이름이 있습니다");
            }
        }
    }

    private void isNotDuplicated(String carName) throws IllegalArgumentException {
        List<String> nameList = new ArrayList<String>(List.of(carName.split(",")));
        Set<String> namesSet = new HashSet<String>(nameList);
        if(nameList.size() != namesSet.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다");
        }
    }


}
