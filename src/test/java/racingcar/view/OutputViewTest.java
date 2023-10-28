package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OutputViewTest {


    @Test
    public void OutputView() {
        OutputView outputView1 = OutputView.getInstance();
        OutputView outputView2 = OutputView.getInstance();

        assertEquals(outputView1, outputView2);
    }
}