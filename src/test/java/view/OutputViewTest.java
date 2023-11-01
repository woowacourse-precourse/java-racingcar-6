package view;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import constants.MessageType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.stubbing.Answer;

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
        // Arrange
        OutputView mockOutput = mock(OutputView.class);
        doAnswer((Answer<Void>) invocation -> { // Void 메소드에 대한 스텁 처리
            outputView.printGameMessage(messageType);
            return null;
        }).when(mockOutput).printGameMessage(messageType);
//        doNothing().when(mockOutput).printGameMessage(messageType);

        // Act: void 메소드 호출
        mockOutput.printGameMessage(messageType);

        // Assert: print()가 1번 호출되었는지 확인
        verify(mockOutput, times(1)).printGameMessage(messageType);
    }

}














