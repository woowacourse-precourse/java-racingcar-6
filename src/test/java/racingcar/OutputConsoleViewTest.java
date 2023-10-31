package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.view.Print.ASKING_CAR_NAME;
import static racingcar.view.Print.ASKING_NUMBER_OF_TRIAL;
import static racingcar.view.Print.FINAL_WINNERS;
import static racingcar.view.Print.RACE_RESULT;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.RaceStatus;
import racingcar.view.OutputConsoleView;



public class OutputConsoleViewTest {

    private OutputConsoleView outputConsoleView;
    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    void setOutput() {
        outputConsoleView = new OutputConsoleView();
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    private String getOutput() {
        return byteArrayOutputStream.toString();
    }

    @Test
    void 차_이름_물어보기() {
        //when
        outputConsoleView.printAskingCarName();
        String output = getOutput();

        //then
        assertThat(output).isEqualTo(ASKING_CAR_NAME + "\n");
    }

    @Test
    void 차_이동_횟수_물어보기(){
        //when
        outputConsoleView.printAskingNumberOfTrial();
        String output = getOutput();

        //then
        assertThat(output).isEqualTo(ASKING_NUMBER_OF_TRIAL + "\n");
    }

    @Test
    void 경기_결과_출력() {
        //when
        outputConsoleView.printRaceResult();
        String output = getOutput();

        //then
        assertThat(output).isEqualTo("\n" + RACE_RESULT+ "\n");
    }

    @Test
    void 차수당_경기_상황() {
        //given
        List<RaceStatus> raceStatuses = new ArrayList<>();
        raceStatuses.add(new RaceStatus("a",3));
        raceStatuses.add(new RaceStatus("b",1));
        raceStatuses.add(new RaceStatus("c",2));

        StringBuilder sb = new StringBuilder();
        for (RaceStatus raceStatus : raceStatuses) {
            sb.append(raceStatus.getName()).append(" : ");
            for (int i = 0; i < raceStatus.getDistance(); i++) {
                sb.append("-");
            }
            sb.append("\n");
        }
        sb.append("\n");

        //when
        outputConsoleView.printRaceStatus(raceStatuses);
        String output = getOutput();

        //then
        assertThat(output).isEqualTo(sb.toString());
    }

    @Test
    void 단독_우승() {
        //given
        List<String> winner = new ArrayList<>();
        winner.add("a");

        StringBuilder sb = new StringBuilder();
        sb.append(FINAL_WINNERS).append(winner.get(0)+"\n");

        //when
        outputConsoleView.printFinalWinners(winner);
        String output = getOutput();

        //then
        assertThat(output).isEqualTo(sb.toString());
    }

    @Test
    void 공동_우승() {
        //given
        List<String> winners = new ArrayList<>();
        winners.add("a");
        winners.add("b");
        winners.add("c");

        StringBuilder sb = new StringBuilder();
        sb.append(FINAL_WINNERS);
        for (int i = 0; i < winners.size(); i++) {
            sb.append(winners.get(i));
            if(i < winners.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("\n");

        //when
        outputConsoleView.printFinalWinners(winners);
        String output = getOutput();

        //then
        assertThat(output).isEqualTo(sb.toString());
    }
}
