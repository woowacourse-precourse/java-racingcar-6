package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputCarFactoryTest  {

    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    private void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    private void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
        Console.close();
    }

    @Test
    void 각_자동차에_이름을_입력받아_자동차를_만든다() {
        //given
        CarFactory carFactory = new InputCarFactory();

        //when
        command("a, b, c");
        List<Car> cars = carFactory.createCars();

        //then
        assertThat(cars.size()).isEqualTo(3);

    }

    @Test
    void 입력받은_자동차_이름이_5글이_이하가_아니라면_에러를_던진다() {
        //given
        CarFactory carFactory = new InputCarFactory();

        //when
        command("aaaa, bbbb, cccccc");

        //then
        assertThatThrownBy(() -> carFactory.createCars())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    private String output() {
        return captor.toString().trim();
    }

}