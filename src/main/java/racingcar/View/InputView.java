package racingcar.View;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class InputView {
    String inputCarname;
    ArrayList<String> Cars = new ArrayList<>();

    public List<String> SplitCarname(String inputCarname) {
        Cars = new ArrayList<>(Arrays.asList(inputCarname.split(",")));
        return Cars;
    }

    public String inputCarname(String name) {
        this.inputCarname = name;
        return inputCarname;
    }

    public List<String> getCars() {
        return Cars;
    }

    public boolean valideFivename(String name) {
        Cars = (ArrayList<String>) SplitCarname(name);
        return Cars.stream().noneMatch(this::isNameOverFiveChars);
    }

    private boolean isNameOverFiveChars(String name) {
        return name.length() > 5;
    }
}