package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.dto.CarDto;

class GameViewTest {
    private static final int MOVE_THRESHOLD = 4;
    private static final String WINNER_NAME_DELIMITER = ", ";

    private final ByteArrayOutputStream testOutputStream = new ByteArrayOutputStream();
    private final PrintStream outputStream = System.out;
    private final GameView gameView = new ConsoleView();

    @BeforeEach
    public void beforeEach() {
        System.setOut(new PrintStream(testOutputStream));
    }

    @AfterEach
    public void afterEach() {
        System.setOut(outputStream);
    }

    @Test
    void 자동차_이름_입력_안내_출력() {
        gameView.printInputCars();
        assertThat(testOutputStream.toString().trim())
                .isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
    }

    @Test
    void 이동_횟수_입력_안내_출력() {
        gameView.printInputMoveCount();
        assertThat(testOutputStream.toString().trim())
                .isEqualTo("시도할 회수는 몇회인가요?");
    }

    @Test
    void 실행_시작_문구_출력() {
        gameView.printExecutionStart();
        assertThat(testOutputStream.toString().trim())
                .isEqualTo("실행 결과");
    }

    @Test
    void 이동_1회_결과_출력() {
        List<CarDto> carDtoList = new ArrayList<>();
        carDtoList.add(CarDto.createNewCarDto("a", 1));
        carDtoList.add(CarDto.createNewCarDto("b", 1));
        gameView.printMoveResult(carDtoList);
        assertThat(testOutputStream.toString())
                .isEqualTo("""
                        a : -
                        b : -
                                                            
                        """);
    }

    @Test
    void 최종_우승자_출력() {
        String userName1 = "poby";
        String userName2 = "toby";
        List<String> multipleWinners = new ArrayList<>();
        multipleWinners.add(userName1);
        multipleWinners.add(userName2);

        gameView.printFinalWinner(multipleWinners);
        assertThat(testOutputStream.toString().trim())
                .isEqualTo("최종 우승자 : " + userName1 + WINNER_NAME_DELIMITER + userName2);

    }
}