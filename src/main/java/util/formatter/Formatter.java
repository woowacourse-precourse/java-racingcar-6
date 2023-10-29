package util.formatter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Formatter {
    public String formatListStringToString(List<String> listString){
        return listString.stream()
                .map(String::trim)
                .collect(Collectors.joining(","));
    }

    public List<String> formatStringToListString(String string){
        return Arrays.asList(string.split(","));
    }
}
