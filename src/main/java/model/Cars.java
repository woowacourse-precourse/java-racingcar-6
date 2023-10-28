package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import utils.Utils;

public class Cars {
    private List<Car> cars;
    Utils utils= new Utils();

    public Cars(String input) {

    }

    public List<Car> getCars() {
        return cars;
    }
}
