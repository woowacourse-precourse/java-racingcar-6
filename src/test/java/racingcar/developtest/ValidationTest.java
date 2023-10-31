package racingcar.developtest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.firstClassCollection.CarName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {


    @Test
    void hasDuplicatedName_중복된_이름_가지고_있는지_확인() {
        CarFactory carFactory = new CarFactory();
        List<String> names = new ArrayList<String>(Arrays.asList("pobi", "crong", "pobi"));
        assertThatThrownBy(() -> carFactory.checkDuplicatedName(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobicrong", "", "po ","po!!"})
     void isValidCarName_자동차_이름_유효한_이름인지_확인(String name){
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
