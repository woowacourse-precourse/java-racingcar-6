package racingcar.domain.car;

import java.util.Arrays;
import java.util.List;

public class NameParser {

    private static int MIN_CAR_COUNT = 2;
    private static final String DELIMETER = ",";

    public List<Name> parseName(String carNames){
        List<String> names = trim(split(carNames));
        checkNameCount(names);

        return names.stream()
                .map(Name::new )
                .toList();
    }

    private String[] split(String carNames){
        return carNames.split(DELIMETER);
    }

    private List<String> trim(String[] carNames){
        return Arrays.stream(carNames)
                .map(String::trim)
                .toList();
    }

    private void checkNameCount(List<String> data){
        if(data.size() < MIN_CAR_COUNT){
            throw new IllegalArgumentException("참여자는 1명 이상이어야 합니다.");
        }
    }

}
