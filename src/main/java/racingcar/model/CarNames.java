package racingcar.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNames {

    private List<String> carNames;

    public CarNames(String carNames) {

        List<String> nameList = split(carNames);
        isDifferentName(nameList);
        for (String name : nameList) {
            overNameLength(name);
        }
        this.carNames = nameList;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public boolean overNameLength(String name) throws IllegalArgumentException {
        if (name.length() > Constant.MAX_CARNAME_LENGTH) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean isDifferentName(List<String> nameList) throws IllegalArgumentException {
        Set<String> set = new HashSet<>();

        for (String name : nameList) {
            if (!set.add(name)) {
                throw new IllegalArgumentException();
            }
        }
        return true;
    }

    public List<String> split(String names) {
        String[] nameArray = names.split(",", -1);
        List<String> nameList = Arrays.asList(nameArray);
        return nameList;
    }
}
