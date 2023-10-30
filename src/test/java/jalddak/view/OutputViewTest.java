package jalddak.view;

import static racingcar.view.SystemMessage.ASK_CAR_LIST;
import static racingcar.view.SystemMessage.ASK_NUM_OF_MATCHES;

import org.junit.jupiter.api.Test;
import racingcar.view.OutputView;

public class OutputViewTest {
    @Test
    void printSystemView_시스템_메세지_출력(){
        OutputView.printSystemMessage(ASK_CAR_LIST);
        OutputView.printSystemMessage(ASK_NUM_OF_MATCHES);
    }
}
