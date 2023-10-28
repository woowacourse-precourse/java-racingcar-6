package racingcar.model.dto;

import java.util.Objects;

public record CarProgressResponse(String name, int result) {

    public CarProgressResponse {
        Objects.requireNonNull(name, "차량 이름은 비어있을 수 없습니다");
    }
}
