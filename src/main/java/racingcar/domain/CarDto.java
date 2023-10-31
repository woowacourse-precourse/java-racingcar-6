package racingcar.domain;

import racingcar.common.consts.SystemConst;
import racingcar.common.consts.SystemMessage;
import racingcar.view.OutputView;

public class CarDto {
    private String name;
    private Integer advance;

    public CarDto(String name, int advance) {
        this.validateName(name);
        this.name = name;
        this.advance = advance;
    }

    public String getName() {
        return name;
    }

    public Integer getAdvance() {
        return advance;
    }

    private void validateName(String name) {
        if (name.length() > SystemConst.MAX_NAME_SIZE) {
            OutputView.printErrMessage(SystemMessage.INVALID_INPUT_NAME_ERROR);
            throw new IllegalArgumentException(SystemMessage.INVALID_INPUT_NAME_ERROR);
        }
    }
}
