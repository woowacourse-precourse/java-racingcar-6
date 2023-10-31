package racingcar.common.type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.common.validator.NamesValidator;

public class Names {
    private final List<Name> nameList;

    private Names(List<Name> nameList) {
        NamesValidator.validate(nameList);
        this.nameList = List.copyOf(nameList);
    }

    public static Names of(String[] names) {
        var list = Arrays.stream(names)
                .map(Name::of)  // String을 Name 객체로 변환
                .collect(Collectors.toList());
        return new Names(list);
    }

    public List<String> getNameList() {
        return nameList.stream()
                .map(Name::getName)
                .collect(Collectors.toList());
    }
}
