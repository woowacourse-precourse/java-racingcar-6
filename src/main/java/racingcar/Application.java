package racingcar;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String testString = ",b,";
        List<String> splitTestString = Arrays.stream(testString.split(",")).toList();
        System.out.println(splitTestString.isEmpty());
        System.out.println(splitTestString.size());
        System.out.println(splitTestString.contains(""));
    }
}
