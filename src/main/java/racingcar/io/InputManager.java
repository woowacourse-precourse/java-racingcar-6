package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputManager {

    public List<String> readNames() {
        String names = Console.readLine();
        System.out.println("names = " + names);
        List<String> nameList = namestoList(names);

        validateNameListSize(nameList);
        validateName(nameList);

        return nameList;
    }

    public int readTrial() {
        String trialInput = Console.readLine();

        validateTrialFormat(trialInput);

        return Integer.parseInt(trialInput);
    }

    public List<String> namestoList(String names) {
        List<String> nameList = Arrays.asList(names.split(","));

        return nameList;
    }

    public void validateNameListSize(List<String> nameList) {
        int nameListSize = nameList.size();

        if(nameListSize <= 1 || nameListSize >= 6) {
            throw new IllegalArgumentException();
        }
    }

    public void validateName(List<String> nameList) {
        Pattern pattern = Pattern.compile("[a-zA-Z]{1,5}");

        for(String name : nameList) {
            if(!pattern.matcher(name).matches()) {
                throw new IllegalArgumentException();
            }
        }
    }


    public void validateTrialFormat(String trialString) {
        Pattern pattern = Pattern.compile("[0-9]");

        if(!pattern.matcher(trialString).matches()) {
            throw new IllegalArgumentException();
        }
    }

}
