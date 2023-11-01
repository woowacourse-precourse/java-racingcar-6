package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class RaceViewTest {

    @Test
    void getCarNames_유효한_입력_테스트1() {
        InputStream input = System.in;
        String content = "a,bc,def,ghij,klnmo,p q r,st u,v w,x yz";
        ByteArrayInputStream in = new ByteArrayInputStream(content.getBytes());
        System.setIn(in);

        List<String> compare = new ArrayList<>();
        compare.add("a");
        compare.add("bc");
        compare.add("def");
        compare.add("ghij");
        compare.add("klnmo");
        compare.add("p q r");
        compare.add("st u");
        compare.add("v w");
        compare.add("x yz");
        assertEquals(compare, RaceView.getCarNames());
    }

    @Test
    void getCarNames_유효한_입력_테스트2() {
        InputStream input = System.in;
        String content = "abcd";
        ByteArrayInputStream in = new ByteArrayInputStream(content.getBytes());
        System.setIn(in);

        List<String> compare = new ArrayList<>();
        compare.add("abcd");
        assertEquals(compare, RaceView.getCarNames());
    }

    @Test
    void getCarNames에_빈_문자열_입력하면_실패() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputStream input = System.in;
            String content = "";
            ByteArrayInputStream in = new ByteArrayInputStream(content.getBytes());
            System.setIn(in);
            RaceView.getCarNames();
        });
    }

    @Test
    void getTotalRound_유효한_입력_테스트() {
        InputStream input = System.in;
        String content = "5";
        ByteArrayInputStream in = new ByteArrayInputStream(content.getBytes());
        System.setIn(in);
        assertEquals(6, RaceView.getTotalRound() + 1);
    }

    @Test
    void getTotalRound_숫자_이외의_다른_문자를_포함한_입력은_실패() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputStream input = System.in;
            String content = "50,000";
            ByteArrayInputStream in = new ByteArrayInputStream(content.getBytes());
            System.setIn(in);
            RaceView.getTotalRound();
        });
    }
}