package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputTest {

    Output output = new Output();

    @Test
    void input_실행_결과를_포함하는_문구_출력(){
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        output.printExecutionResult(0,"pobi : ---");

        assertThat(out.toString()).contains("실행 결과");
    }

    @Test
    void input_최종_우승자를_포함하는_문구_출력(){
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        output.printFinalWinner("pobi, suyeon");

        assertThat(out.toString()).contains("최종 우승자");
    }
}