package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import racingcar.util.Validator;

public class Names {

    private List<String> nameList;

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
