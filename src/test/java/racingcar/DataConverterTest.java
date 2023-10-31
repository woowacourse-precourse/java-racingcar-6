package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class DataConverterTest {

    @Test
        //String -> List<String> 변환 메서드
    void 데이터_형식_변환_확인() {
        DataConverter dataConverter = new DataConverter();

        String str = "Benz,아우디";
        List<String> result = dataConverter.toListString(str);

        assertThat(result).containsExactly("Benz", "아우디");
    }

}