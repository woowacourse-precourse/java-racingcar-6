package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class AnnouncerTest {

    @Test
    void enterCarNamesSay() {
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));

        Announcer announcer = new Announcer();
        announcer.sayEnterCars();

        Assertions.assertThat(os.toString()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
    }

    @Test
    void enterAttemptSay() {
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));

        Announcer announcer = new Announcer();
        announcer.sayEnterAttempt();

        Assertions.assertThat(os.toString()).isEqualTo("시도할 회수는 몇회인가요?\n");
    }
}
