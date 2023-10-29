package racingcar.model.dto;

import static racingcar.constant.ErrorMessage.EMPTY_STRING_ERROR;

import org.junit.platform.commons.util.StringUtils;

public record CarProgressResponse(String name, int result) {

    public CarProgressResponse {
        if(StringUtils.isBlank(name)) {
            throw new IllegalArgumentException(EMPTY_STRING_ERROR.getMessage());
        }
    }
}
