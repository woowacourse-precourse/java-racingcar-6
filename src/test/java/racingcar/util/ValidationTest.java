package racingcar.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidationTest {

    static Validation validation;

    @Test
    void 이름이_유효한_입력_일_경우() {
        validation = new Validation();
        var names = List.of("matia", "maria");

        validation.validateCarNames(names);
    }

    @Test
    void 이름이_5자초과_일_경우_예외_처리() {
        validation = new Validation();
        var names = List.of("matia", "mamatia");

        assertThrows(IllegalArgumentException.class, () -> validation.validateCarNames(names));
    }

    @Test
    void 이름이_중복될_경우_예외_처리() {
        validation = new Validation();
        var names = List.of("matia", "matia");

        assertThrows(IllegalArgumentException.class, () -> validation.validateCarNames(names));
    }

    @Test
    void 이름이_없을_경우_예외_처리() {
        validation = new Validation();
        var names = List.of("matia", "");

        assertThrows(IllegalArgumentException.class, () -> validation.validateCarNames(names));
    }

    @Test
    void 시도_회수가_유효한_입력_일_경우() {
        validation = new Validation();
        String inputString = "5";

        validation.validateNumberOfRaces(inputString);
    }

    @Test
    void 시도_회수가_숫자가_아닐_경우_예외_처리() {
        validation = new Validation();
        String inputString = "fkfkfk";

        assertThrows(IllegalArgumentException.class, () -> validation.validateNumberOfRaces(inputString));
    }

    @Test
    void 시도_회수가_1미만_일_경우_예외_처리() {
        validation = new Validation();
        String inputString = "0";

        assertThrows(IllegalArgumentException.class, () -> validation.validateNumberOfRaces(inputString));
    }
}
