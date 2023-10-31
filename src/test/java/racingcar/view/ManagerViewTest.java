package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.manager.view.ManagerView;

public class ManagerViewTest {

    private static String FINAL_WINNERS = "최종 우승자 : ";
    private final ManagerView managerView = new ManagerView();

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams(){
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void 차량_움직인_거리_출력_테스트(){
        Integer moveCount = 5;
        String stringMoveCount = managerView.getTotalMoveCount(moveCount);
        assertThat(stringMoveCount).isEqualTo("-----");
    }

    @Test
    void 최종_우승자_출력_테스트(){
        List<String> winnerCars = new ArrayList<>();
        winnerCars.add("pobi");
        winnerCars.add("jun");
        winnerCars.add("woni");

        managerView.printFinalWinners(winnerCars);
        String expectedResult = FINAL_WINNERS + "pobi, jun, woni";

        assertThat(output.toString()).isEqualTo(expectedResult);
    }
}
