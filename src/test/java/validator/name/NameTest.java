package validator.name;

import racingcar.model.RaceCar;
import racingcar.service.GameService;
import racingcar.validator.Validator;
import racingcar.message.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NameTest {
    @DisplayName("name_자동차_이름이_빈_문자열_예외_처리")
    @Test
    void name_자동차_이름이_빈_문자열_예외_처리() {
        List<String> names = Arrays.asList("pobi,,songe".split(",", -1));
        Validator validator = new Validator();

        assertThatThrownBy(() -> validator.checkLengthName(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.EXCEPTION_NAME_UNDER);
    }

    @DisplayName("name_자동차_이름이_5_초과_예외_처리")
    @Test
    void name_자동차_이름이_5_초과_예외_처리() {
        List<String> names = Arrays.asList("pobi,songyi".split(",", -1));
        Validator validator = new Validator();

        assertThatThrownBy(() -> validator.checkLengthName(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.EXCEPTION_NAME_OVER);
    }

    @DisplayName("name_자동차_이름이_null_예외_처리")
    @Test
    void name_자동차_이름이_null_예외_처리() {
        List<String> names = new ArrayList<>();
        names.add(null);
        Validator validator = new Validator();

        assertThatThrownBy(() -> validator.checkLengthName(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.EXCEPTION_NAME_NULL);
    }

    @DisplayName("name_이름에_공백이_있을_경우_공백도_출력")
    @Test
    void name_이름에_공백이_있을_경우_공백도_출력() {
        List<String> names = Arrays.asList("po bi,songe, rose".split(",", -1));
        List<RaceCar> raceCars = new ArrayList<>();
        Validator validator = new Validator();
        validator.checkLengthName(names);

        GameService gameService = new GameService();

        raceCars = gameService.createRaceCarObject(raceCars, names);

        assertThat(raceCars).extracting("name")
                .contains("po bi", "songe", " rose");
    }

    @DisplayName("name_구분자가_포함되지_않은_경우_값을_그대로_출력")
    @Test
    void name_구분자가_포함되지_않은_경우_값을_그대로_출력() {
        List<String> names = Arrays.asList("pobi".split(",", -1));
        List<RaceCar> raceCars = new ArrayList<>();
        GameService gameService = new GameService();
        Validator validator = new Validator();
        validator.checkLengthName(names);

        raceCars = gameService.createRaceCarObject(raceCars, names);

        assertThat(raceCars).extracting("name")
                .contains("pobi");
    }
}