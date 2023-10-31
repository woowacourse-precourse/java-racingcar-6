package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.request.CarNameRequest;
import racingcar.dto.request.TotalRoundNumberRequest;
import racingcar.exception.UserInputException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputViewTest {
    private InputStream inputStream;

    @AfterEach
    public void afterEach() throws IOException {
        Console.close();
    }

    @Test
    @DisplayName("자동차 이름 입력값을 콤마로 구분하여 리스트로 반환")
    public void requestCarNames_입력값을_콤마로_구분하여_리스트로_반환한다() throws Exception {
        String input = "kim,lee";
        initInputStream(input);
        List<CarNameRequest> carNameRequests = InputView.requestCarNames();
        List<String> carNames = carNameRequests.stream().map(CarNameRequest::getName).toList();

        assertThat(carNames).contains("lee", "kim");
        assertThat(carNames).containsExactly("kim", "lee");
    }

    @Test
    @DisplayName("자동차 이름 입력시 공백인 경우 예외 발생")
    public void requestCarNames_입력값이_공백인_경우_예외가_발생한다() throws Exception {
        String input = " ";
        initInputStream(input);
        assertThrows(
                UserInputException.class, () -> InputView.requestCarNames()
        );
    }

    @Test
    @DisplayName("라운드수 입력값을 숫자로 파싱후 객체로 반환")
    public void requestTotalRoundCount_입력값을_숫자로_파싱후_객체로_반환한다() throws Exception {
        String input = "3";
        initInputStream(input);
        TotalRoundNumberRequest totalRoundNumberRequest = InputView.requestTotalRoundNumber();
        int totalCount = totalRoundNumberRequest.getTotalCount();

        assertThat(totalCount).isEqualTo(Integer.parseInt(input));
    }

    @Test
    @DisplayName("라운드수 입력시 숫자가 아닌 경우 예외 발생")
    public void requestTotalRoundCount_입력값이_숫자가_아닌경우_예외가_발생한다() throws Exception {
        String input = "a";
        initInputStream(input);
        assertThrows(
                UserInputException.class, () -> InputView.requestTotalRoundNumber()
        );
    }

    @Test
    @DisplayName("라운드 수 입력시 공백인 경우 예외 발생")
    public void requestTotalRoundCount_입력값이_공백인_경우_예외가_발생한다() throws Exception {
        String input = " ";
        initInputStream(input);
        assertThrows(
                UserInputException.class, () -> InputView.requestTotalRoundNumber()
        );
    }

    public void initInputStream(String input) {
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}