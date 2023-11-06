package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class NamesInputConverterTest {

    @Test
    void String을_쉼표_기준으로_잘라_String_List로_변환할_수_있다() {
        List<String> names = NamesInputConverter.convertToNames("jinho,abcd,efg");

        assertThat(names.size()).isEqualTo(3);
        assertThat(names.get(0)).isEqualTo("jinho");
        assertThat(names.get(1)).isEqualTo("abcd");
        assertThat(names.get(2)).isEqualTo("efg");
    }

    @Test
    void String_변환시_공란은_무시된다() {
        List<String> names = NamesInputConverter.convertToNames("jinho,,,,,efg");

        assertThat(names.size()).isEqualTo(2);
        assertThat(names.get(0)).isEqualTo("jinho");
        assertThat(names.get(1)).isEqualTo("efg");
    }
}
