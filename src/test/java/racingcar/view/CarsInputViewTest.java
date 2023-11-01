package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.errormessage.InputError;
import racingcar.model.Car;

class CarsInputViewTest {

    CarsInputView carsInputView = new CarsInputView();

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @DisplayName("정상입력")
    @Test
    void isCorrectInput(){
        // Given
        String names ="pobi,woni,jun";
        System.setIn(createUserInput(names));
        String arr[] = names.split(",");

        // When
        List<Car> result = carsInputView.generateInputList();

        // Then
        for(int i=0;i<result.size();++i){
            if(!result.get(i).getName().equals(arr[i])) fail();
        }
    }

    @DisplayName("입력한이름갯수!=쉼표+1_일때")
    @Test
    void isAccurateNameCount() {
        // Given
        System.setIn(createUserInput("pobi,woni,jun,"));

        // When
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> carsInputView.generateInputList());

        // Then
        Assertions.assertThat(exception.getMessage()).isEqualTo(InputError.INPUT_ERROR_MESSAGE);
    }

    @DisplayName("입력한이름중_공백이름_있을때")
    @Test
    void isSpaceName() {
        // Given
        System.setIn(createUserInput("pobi,,woni,jun"));

        // When
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> carsInputView.generateInputList());

        // Then
        Assertions.assertThat(exception.getMessage()).isEqualTo(InputError.INPUT_SPACE_ERROR_MESSAGE);
    }
}