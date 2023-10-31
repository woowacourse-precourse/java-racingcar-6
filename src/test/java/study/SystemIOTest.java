package study;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SystemIOTest {

    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    private String output() {
        return captor.toString().trim();
    }

    @Test
    void 콘솔에서_전달받은_입력값을_미리_세팅할_수_있다() {
        //given
        String args = "1,2,3";
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        //when
        Main.main(new String[]{});

        //then
        assertThat(output()).contains("1", "2", "3");
    }

    static class Main {
        public static void main(String[] args) {
            String[] array = Console.readLine().split(",");

            for (String str : array) {
                System.out.println(str);
            }
        }
    }
}
