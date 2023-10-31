package racingcar.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void nullTest(){
        String[] arr = new String[3];

        Assertions.assertThat(arr[0]).isEqualTo(null);
    }

    @Test
    void splitTest(){
        String names = "party, rock,, take";
        String[] arr = names.split(",");

        Assertions.assertThat(arr[2]).isNotNull();
    }
}
