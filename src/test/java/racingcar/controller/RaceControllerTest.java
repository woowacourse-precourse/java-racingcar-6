package racingcar.controller;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.view.InputView;
import racingcar.view.OutputView;

class RaceControllerTest {
    private RaceController raceController;
    @BeforeEach
    void setUp() {
        raceController = new RaceController(new InputView(), new OutputView());
    }
}