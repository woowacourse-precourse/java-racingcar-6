package racingcar;

import java.util.List;

public class UserInputReceiver {

    public static List<String> receiveCarNameAndGetCarNameList(String rawInput) {

        List<String> split = List.of(rawInput.split(","));

        elementLengthValidate(split);

        return split;
    }

    private static void elementLengthValidate(List<String> split) {
        split.forEach(e->{
            if(e.length()>=5) throw new IllegalArgumentException();
        });
    }

}
