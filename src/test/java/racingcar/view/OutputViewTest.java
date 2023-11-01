package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class OutputViewTest {
    @Test
    void 포지션을_작대기로_변환하여_출력하라 () {
        //given
        String name = "pobi";
        Car car = new Car(name);
        //when
        car.moveForward();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        car.printCarResult();
        String outputMessage = outputStream.toString();
        //then
        assertThat(outputMessage).contains("pobi : -");
    }

}
