package racingcar.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    Cars cars = new Cars();
    List<String> list = new ArrayList<>();

    @BeforeEach
    void before() {
        for (String key : "a,b,c".split(",")) list.add(key);
        cars.setCarsData(list);
    }

    @AfterEach
    void after() {
        cars.getCarsData().clear();
        list.clear();
    }

    @Test
    @DisplayName("carsData의 value가 0으로 잘 설정됬는지 확인")
    void setCarsData() {
        Map<String, Integer> carsData = cars.getCarsData();

        assertThat(carsData.get("a")).isSameAs(0);
        assertThat(carsData.get("b")).isSameAs(0);
        assertThat(carsData.get("c")).isSameAs(0);
    }

    @Test
    @DisplayName("셋팅한 carsData가 공용으로 잘 사용되는지 검사")
    void getCarsData() {
        Cars newCars = new Cars();

        Map<String, Integer> carsData = cars.getCarsData();
        Map<String, Integer> compareCarsData = newCars.getCarsData();

        assertThat(carsData).isSameAs(compareCarsData);
    }
}