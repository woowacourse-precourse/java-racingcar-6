package Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import Model.RacingCar;
import org.junit.jupiter.api.Test;
import View.InputView;
import Validator.Validator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DuplicatedNameTest {

    @Test
    void 중복된_이름(){
        InputView inputView = new InputView();
        String input = "test,test,test1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(inputView::getNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.getMessage("DUPLICATED_NAME"));
    }
}
