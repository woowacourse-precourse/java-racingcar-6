package racingcar.domain;

import racingcar.global.constant.CommonNumberType;
import racingcar.global.constant.OutputType;
import java.util.List;

public class ClientNames {

    private final List<String> nameList;
    private final Integer nameCount;

    public ClientNames(List<String> nameList) {
        validateNames(nameList);
        this.nameList = nameList;
        this.nameCount = createNameCount(nameList);
    }

    private int createNameCount(List<String> nameList) {
        return nameList.size();
    }

    private void validateNames(List<String> nameList) {
        for (String name : nameList) {
            if (isWrongInput(name)) {
                throw new IllegalArgumentException(OutputType.EXCEPTION.getComment());
            }
        }
    }

    private boolean isWrongInput(String name) {
        return !(shouldInvalidLength(name));
    }

    private boolean shouldInvalidLength(String name) {
        return name.length() <= CommonNumberType.MAXIMUM_LENGTH_OF_NAME.getValue();
    }

    public List<String> getNames() {
        return nameList;
    }

    public Integer getNameCount() {
        return nameCount;
    }
}
