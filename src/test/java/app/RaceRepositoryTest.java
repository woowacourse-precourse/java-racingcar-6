package app;

import app.repository.RaceRepository;
import app.repository.Valid;
import app.template.InputTemplate;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;

class RaceRepositoryTest {

    private void command(String[] args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @AfterEach
    private void close() {
        Console.close();
    }

    private final RaceRepository raceRepository = new RaceRepository();
    private final Valid valid = new Valid();
    private final InputTemplate template = new InputTemplate();

    @Test
    @DisplayName("getCarName 정상흐름")
    void getCarName() {
        String[] input = {"a,b,c,d,e", "a", "aaaa,qqqq,cccc,dddd,eeee,ffff,zxcv,asdf,qwer"};
        command(input);

        for (String inputName : input) {
            String name = raceRepository.getCarName();
            assertThat(name).isEqualTo(inputName);
        }
    }
    @Test
    @DisplayName("getCarName 예외흐름")
    void getCarNameException() {
        String[] input = {null, "", " ", "   ", "aaaaa", "a,,d", ",d,", ",,,"};
        command(input);

        for (String inputName : input) {
            assertThatThrownBy(() -> raceRepository.getCarName())
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("getRaceCount() 정상흐름")
    void getRaceCount() {
        String[] input = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        command(input);

        for (String inputName : input) {
            String getName = raceRepository.getRaceCount();
            assertThat(getName).isEqualTo(inputName);
        }

    }

    @Test
    @DisplayName("getRaceCount() 예외흐름")
    void getRaceCountException() {
        String[] input = {null, "", " ", "   ", "aaaaa", "a,,d", ",d,", ",,,", "0", "a", "123123", " 123", "1 23", "1 1"};
        command(input);

        for (String inputName : input) {
            assertThatThrownBy(() -> raceRepository.getRaceCount())
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }
}