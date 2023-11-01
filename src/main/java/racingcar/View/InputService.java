package racingcar.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class InputService {
    String inputCarname;
    ArrayList<String> Cars = new ArrayList<>();
    String inputTryNum;

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

    public String inputTryNum(String tryNum) {
       return this.inputTryNum=tryNum;

    }
}