package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class CarGeneratorTest {

    private CarGenerator T;

    @BeforeEach
    void setUp() {
        T = new CarGenerator();
    }

    @Test
    void splitStringByCommas_쉼표기준_분리_테스트() {
        //given
        final String case1 = "pobi";
        final String case2 = "pobi,jason";
        final String case3 = "pobi,jason,juno";
        final String case4 = "pobi,jason,juno,hyun";
        final String case5 = "pobi,jason,juno,hyun,minseo";

        //when
        final String[] result1 = T.splitStringByCommas(case1);
        final String[] result2 = T.splitStringByCommas(case2);
        final String[] result3 = T.splitStringByCommas(case3);
        final String[] result4 = T.splitStringByCommas(case4);
        final String[] result5 = T.splitStringByCommas(case5);

        //then
        assertThat(result1).containsExactly("pobi");
        assertThat(result2).containsExactly("pobi", "jason");
        assertThat(result3).containsExactly("pobi", "jason", "juno");
        assertThat(result4).containsExactly("pobi", "jason", "juno", "hyun");
        assertThat(result5).containsExactly("pobi", "jason", "juno", "hyun", "minseo");
    }

    @Test
    void createCarList_자동차리스트_값_테스트() {
        //given
        final String case1 = "povi1";
        final String case2 = "povi1,povi2";
        final String case3 = "povi1,povi2,povi3";

        //when
        final LinkedHashMap<String, String> result1 = T.createCarList(case1);
        final LinkedHashMap<String, String> result2 = T.createCarList(case2);
        final LinkedHashMap<String, String> result3 = T.createCarList(case3);

        //then
        assertThat(result1).containsKey("povi1");
        assertThat(result2).containsKey("povi1");
        assertThat(result2).containsKey("povi2");
        assertThat(result3).containsKey("povi1");
        assertThat(result3).containsKey("povi2");
        assertThat(result3).containsKey("povi3");

    }
}
