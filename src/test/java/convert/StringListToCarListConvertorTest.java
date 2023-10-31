package convert;

import domain.Car;
import factory.CarFactory;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.convertor.StringListToCarListConvertor;

public class StringListToCarListConvertorTest {

    @ParameterizedTest
    @DisplayName("문자열 리스트 자동차 리스트 변환 검증 테스트")
    @MethodSource("provideStringListAndCarList")
    void stringListToCarListConvertTest(List<String> strings, List<Car> expect) {
        //when
        List<Car> result = StringListToCarListConvertor.convert(strings);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

    static Stream<Arguments> provideStringListAndCarList() {
        return Stream.of(
                Arguments.of(
                        createStringList("name1", "name2"),
                        createCarList("name1", "name2")
                ),
                Arguments.of(
                        createStringList("alpha", "beta", "gamma"),
                        createCarList("alpha", "beta", "gamma")
                )
        );

    }

    private static List<Car> createCarList(String... names) {
        return Arrays.stream(names)
                .map(name -> CarFactory.createCar(name, 0))
                .collect(Collectors.toList());
    }

    private static List<String> createStringList(String... names) {
        return Arrays.asList(names);
    }
}
