package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.controller.CarNames;

public class InputNameTest {

    @Test
    void splitName_확인1() {
        String ts = "1,2,3,4,5, 6 , ";
        InputStream in = new ByteArrayInputStream(ts.getBytes());
        System.setIn(in);
        List<String> expected = new ArrayList<>(
                Arrays.asList("1", "2", "3", "4", "5", " 6 ", " ")
        );
        assertThat(CarNames.splitName()).isEqualTo(expected);
    }
    @Test
    void splitName_확인2() {
        String ts = "1,";
        InputStream in = new ByteArrayInputStream(ts.getBytes());
        System.setIn(in);
        List<String> expected = new ArrayList<>(
                Arrays.asList("1")
        );
        assertThat(CarNames.splitName()).isEqualTo(expected);
    }

    @Test
    void splitName_에러확인() {
        String ts = "asdf, a123456";
        InputStream in = new ByteArrayInputStream(ts.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> CarNames.splitName())
                .isInstanceOf(IllegalArgumentException.class);
    }
//    @Test
//    void splitName_에러확인2() {
//        String ts = "";
//        InputStream in = new ByteArrayInputStream(ts.getBytes());
//        System.setIn(in);
//
//        assertThatThrownBy(() -> CarNames.splitName())
//                .isInstanceOf(IllegalArgumentException.class);
//    }
    @Test
    void splitName_에러확인3() {
        String ts = ",1";
        InputStream in = new ByteArrayInputStream(ts.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> CarNames.splitName())
                .isInstanceOf(IllegalArgumentException.class);
    }


}
