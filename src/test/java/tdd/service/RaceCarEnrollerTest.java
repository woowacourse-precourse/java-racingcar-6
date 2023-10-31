package tdd.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import org.junit.jupiter.api.Test;
import tdd.domain.Car;

public class RaceCarEnrollerTest {
    @Test
    void 등록된_자동차들이_일치하면_통과() {
        List<String> validatedCarNames = new ArrayList<>();
        RaceCarEnroller carEnroller = new RaceCarEnroller();

        validatedCarNames.add("Car1");
        validatedCarNames.add("Car2");

        LinkedHashSet<Car> enrolledCars = carEnroller.enrollCars(validatedCarNames);
        Iterator<Car> iterator = enrolledCars.iterator();
        assertThat(iterator.next().getName()).isEqualTo("Car1");
        assertThat(iterator.next().getName()).isEqualTo("Car2");
    }
}
