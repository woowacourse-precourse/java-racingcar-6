package util.convertor;
import java.util.List;

public class StringToStringListConvertor {

    private static final String DELIMITER = ",";

    public static List<String> convert(String value) {
        return List.of(value.split(DELIMITER));
    }

}
