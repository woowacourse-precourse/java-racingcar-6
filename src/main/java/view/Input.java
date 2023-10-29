package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {


    public static List<String> carName() {
        String[] carNames = Console
                .readLine()
                .split(",");
        Exception.nameVerification(carNames);
        System.out.println(Arrays.toString(carNames));
        return Arrays.asList(carNames);
    }

    public static void main(String[] args) {
        carName();
    }

}
