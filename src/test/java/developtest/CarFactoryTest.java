package developtest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.CarFactory;

public class CarFactoryTest {
    private CarFactory carFactory;


    @BeforeEach
    void setUp(){
        carFactory = new CarFactory();
    }

    @ParameterizedTest
    @ValueSource(strings={"pobi,crong"})
    void stringtoListByComma_콤마를_기준으로_문자열을_리스트로_변환(String string){
        List<String> result = carFactory.stringtoListByComma(string);
        assertThat(result.toString()).isEqualTo(Arrays.asList("pobi","crong").toString());
    }

}
