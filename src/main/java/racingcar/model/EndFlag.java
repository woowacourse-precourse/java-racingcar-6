package racingcar.model;

import racingcar.enums.GameConstant;

public class EndFlag {
    private Boolean endFlag;

    public EndFlag() {
        this.endFlag = false;
    }

    public Boolean update(Boolean bool) {
        this.endFlag = bool;
        return this.endFlag;
    }
}
