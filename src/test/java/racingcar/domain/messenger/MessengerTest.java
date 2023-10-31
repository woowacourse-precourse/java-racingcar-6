package racingcar.domain.messenger;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarInformationDto;
import racingcar.dto.CarNamesDto;
import racingcar.dto.CarsInformationDto;

public class MessengerTest {

    private final Messenger messenger = new Messenger();

    @Test
    @DisplayName("자동차 이름 입력 요구 메시지를 올바르게 반환한다.")
    void requestCarNames() {
        // when
        String expectedString = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
        String string = messenger.getRequestCarNames();

        // then
        Assertions.assertEquals(string, expectedString);
    }

    @Test
    @DisplayName("라운드 횟수 입력 요구 메시지를 올바르게 반환한다.")
    void requestRoundCount() {
        // when
        String expectedString = "시도할 회수는 몇회인가요?\n";
        String string = messenger.getRequestRoundCount();

        // then
        Assertions.assertEquals(string, expectedString);
    }

    @Test
    @DisplayName("실행 결과 메시지를 올바르게 반환한다.")
    void playResultMessage() {
        // when
        String expectedString = "\n실행결과\n";
        String string = messenger.getPlayResultMessage();

        // then
        Assertions.assertEquals(string, expectedString);
    }

    @Test
    @DisplayName("라운드 결과를 올바르게 반환한다.")
    void roundResultMessage() {
        // given
        CarsInformationDto carsInformationDto = new CarsInformationDto(
                List.of(
                        new CarInformationDto("차1",0),
                        new CarInformationDto("차2",1),
                        new CarInformationDto("차3",2),
                        new CarInformationDto("차4",3)
                )
        );

        // when
        String expectedString = "차1 : \n차2 : -\n차3 : --\n차4 : ---\n\n";
        String string = messenger.getRoundResult(carsInformationDto);

        // then
        Assertions.assertEquals(string, expectedString);
    }

    @Test
    @DisplayName("최종 우승자가 한 명일 때, 메시지를 올바르게 반환한다.")
    void winner() {
        // given
        CarNamesDto carNamesDto = new CarNamesDto(
                List.of("차1")
        );

        // when
        String expectedString = "최종 우승자 : 차1\n";
        String string = messenger.getWinners(carNamesDto);

        // then
        Assertions.assertEquals(string, expectedString);
    }

    @Test
    @DisplayName("최종 우승자가 여러 명일 때, 메시지를 올바르게 반환한다.")
    void winners() {
        // given
        CarNamesDto carNamesDto = new CarNamesDto(
                List.of("차1", "차2")
        );

        // when
        String expectedString = "최종 우승자 : 차1, 차2\n";
        String string = messenger.getWinners(carNamesDto);

        // then
        Assertions.assertEquals(string, expectedString);
    }

}
