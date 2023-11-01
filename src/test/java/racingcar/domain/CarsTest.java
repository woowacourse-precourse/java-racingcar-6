package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

class CarsTest {
    @DisplayName("레이싱에 참여하는 자동차들이 생성되는지 확인한다.")
    @Test
    void 레이싱_참여_자동차_생성_테스트() {
        Cars cars = Cars.from(Arrays.stream("pobi,yd".split(","))
                .collect(Collectors.toList()));
        Assertions.assertThat(cars.getCars()).extracting("name").contains("pobi", "yd");
    }
}