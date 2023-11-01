package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import racingcar.util.Validator;

/**
 * 자동차 이름들을 담는 클래스
 */
public class Names {

    private List<String> nameList;

    /**
     * Names 생성자
     * <p>
     * 입력값을 검증하고 초기화<br> 앞뒤 공백은 사용자 실수로 간주하고 제거
     *
     * @param names 입력값
     */
    public Names(String names) {
        nameList = makeNameList(names);
        new Validator().names(nameList);
    }

    private List<String> makeNameList(String names) {
        nameList = Arrays.asList(names.split(",", -1));
        for (int i = 0; i < nameList.size(); i++) {
            nameList.set(i, nameList.get(i).trim());
        }
        return nameList;

    }

    public Cars toCars() {
        Cars cars = new Cars();
        for (String carName : nameList) {
            cars.add(carName);
        }
        return cars;
    }

}
