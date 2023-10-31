package racingcar;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Car {
    private static final String COMMA = ",";
    private static final int LENGTH = 5;

    private List<String> racer_name = new ArrayList<>();
    private String name = "";

    public Car() {

    }

    public List<String> getRacerName() {
        name = readLine();
        racer_name = parsingName(name);
        checkInput(racer_name);
        return racer_name;
    }

    public List<String> parsingName(String name) {
        if (containComma(name)) {
            String[] racer_names = name.split(",");
            return arrayToList(racer_names);
        }
        racer_name.add(name);
        return racer_name;
    }

    private List<String> arrayToList(String[] racer_names) {
        for (String racer : racer_names) {
            racer_name.add(racer);
        }
        return racer_name;
    }

    private boolean containComma(String name) {
        if (name.contains(COMMA)) {
            return true;
        }
        return false;
    }

    private boolean checkInput(List<String> racer_name) {
        if (!checkNameLength(racer_name)) {
            throw new IllegalArgumentException();
        }
        if (!checkNameString(racer_name)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private boolean checkNameLength(List<String> racer_name) {
        for (String name : racer_name) {
            if (name.length() > LENGTH) {
                return false;
            }
        }
        return true;
    }

    private boolean checkNameString(List<String> racer_name) {
        for (String name : racer_name) {
            if (containsNumber(name)) {
                return false;
            }
        }
        return true;
    }

    private static boolean containsNumber(String input) {

        Pattern pattern = Pattern.compile(".*\\d.*");
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

}
