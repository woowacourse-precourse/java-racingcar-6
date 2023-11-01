package domain;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private List<String> cars = new ArrayList<>();
    private List<String> results = new ArrayList<>();

    public List<String> getCars() {
        return cars;
    }

    public List<String> getResults() {
        return results;
    }

}
