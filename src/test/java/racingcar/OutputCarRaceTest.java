package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class OutputCarRaceTest extends PrintTest{
    enum MessageType{
        INPUT_CAR_NAME_PRINT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        INPUT_CAR_RACING_COUNT("시도할 회수는 몇회인가요?");

        private final String value;

        MessageType(String value){
            this.value = value;
        }

        public String getValue(){
            return value;
        }
    }

    static class OutputCarRace{
        public static OutputCarRace print(final MessageType messageType){
            return new OutputCarRace(messageType);
        }

        private OutputCarRace(){}

        private OutputCarRace(final MessageType messageType){
            System.out.println(messageType.getValue());
        }
    }

    @Test
    void 자동차_이름입력멘트_출력_정상(){
        OutputCarRace.print(MessageType.INPUT_CAR_NAME_PRINT);

        assertThat(output()).contains(MessageType.INPUT_CAR_NAME_PRINT.getValue());
    }

    @Test
    void 자동차_경주회수_출력_정상(){
        OutputCarRace.print(MessageType.INPUT_CAR_RACING_COUNT);

        assertThat(output()).contains(MessageType.INPUT_CAR_RACING_COUNT.getValue());
    }
}
