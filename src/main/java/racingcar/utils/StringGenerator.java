package racingcar.utils;
import java.util.List;

public class StringGenerator {
    public static List<String> generateCarName(String input, String regex){
        return List.of(input.split(regex));
    }
}
