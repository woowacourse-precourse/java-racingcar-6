package racingcar.common;

import java.util.ArrayList;
import java.util.List;
import org.mockito.internal.util.collections.ListUtil.Converter;

public class StringToListConverter implements Converter<String, List<String>> {
    @Override
    public List<String> convert(String from) {
        String[] names = from.split(",");
        List<String> namesList = new ArrayList<>();
        for (String name : names) {
            if (name.equals("")) {
                continue;
            }
            if (name.trim().equals("")) {
                return null;
            }
            namesList.add(name.trim());
        }
        return namesList;
    }
}
