//package racingcar.controller;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.BDDMockito;
//import org.mockito.MockedStatic;
//import org.mockito.Mockito;
//import racingcar.OutputTestSupport;
//import racingcar.util.Randoms;
//
//import java.io.ByteArrayInputStream;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//class RaceGameControllerTest extends OutputTestSupport {
//
//    private RaceGameController raceGameController;
//
//    @BeforeEach
//    void setUp(){
//        String input = "haen\n2";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        raceGameController = new RaceGameController();
//    }
//
//    @AfterEach
//    void tearDown(){
//        camp.nextstep.edu.missionutils.Console.close();
//    }
//
//
//    @Test
//    @DisplayName("게임을 진행하는 객체를 생성해서 실행한다.")
//    public void start() {
//        // given
//        String result = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n" +
//                "시도할 회수는 몇회인가요?\n" +
//                "\n" +
//                "실행 결과\n" +
//                "haen : -\n" +
//                "\n" +
//                "haen : --\n\n";
//
//        try (final MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
//            BDDMockito.given(Randoms.getNumber()).willReturn(4);
//            // when
//            raceGameController.startGame();
//        }
//        //then
//        assertThat(getOutput()).isEqualTo(result);
//    }
//
//    @Test
//    @DisplayName("승리한 자동차의 이름을 출력할 수 있다.")
//    public void printWinningCarNames() {
//        // given
//        String result = "최종 우승자 : haen";
//        // when
//        init();
//        raceGameController.printWinningCarNames();
//        // then
//        assertThat(getOutput()).isEqualTo(result);
//    }
//
//}