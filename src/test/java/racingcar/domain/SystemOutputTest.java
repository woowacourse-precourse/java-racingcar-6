//package racingcar.domain;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import java.io.PrintStream;
//import java.io.ByteArrayOutputStream;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//class SystemOutputTest {
//    @DisplayName("출력형태확인")
//    @Test
//    void 출력형태_확인(){
//        Map<String, Integer> numMoveMap = new HashMap();
//        SystemOutput systemOutput = new SystemOutput();
//
//        numMoveMap.put("사카", 1);
//        numMoveMap.put("라이스", 0);
//        numMoveMap.put("외데고르", 1);
//
//        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outputStreamCaptor));
//
//        systemOutput.printMoveResult(numMoveMap);
//
//        String expectedOutput =
//                "사카 : -"+"\n"+
//                "외데고르 : -"+"\n"+
//                "라이스 : \n"+"\n";
//
//        assertThat(outputStreamCaptor.toString()).contains("사카 : -","외데고르 : -","라이스 : ");
//    }

//import org.junit.jupiter.api.Test;
//
//@Test
//    void 출력최종결과_확인(){
//        Map<String, Integer> numMoveMap = new HashMap();
//        SystemOutput systemOutput = new SystemOutput();
//
//        numMoveMap.put("사카", 1);
//        numMoveMap.put("라이스", 0);
//        numMoveMap.put("외데고르", 1);
//
//        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outputStreamCaptor));
//
//        List<String> winnerList = GameService.getWinner(numMoveMap);
//        systemOutput.printOverallResult(winnerList);
//
//        assertThat(outputStreamCaptor.toString()).contains("사카","외데고르");
//
//    }
//
//
//}