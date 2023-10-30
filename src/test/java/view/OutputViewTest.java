package view;

import static org.assertj.core.api.Assertions.assertThat;

import constants.MessageType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class OutputViewTest {

    OutputView outputView;

    @BeforeEach
    void init(){
        outputView = new OutputView();
    }

    @DisplayName("MessageType 에 알맞는 메세지 출력")
    @ParameterizedTest
    @EnumSource(MessageType.class)
    void getGameMessageTest(MessageType messageType){
        String message = messageType.getMessage();
        assertThat(message).isEqualTo(outputView.getGameMessage(messageType));
    }

}
