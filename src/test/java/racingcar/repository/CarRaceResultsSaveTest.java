//package racingcar.repository;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//import org.junit.jupiter.api.Test;
//import racingcar.util.CarRacingStarts;
//import racingcar.util.PickRandomNumber;
//
//public class CarRaceResultsSaveTest {
//
//    @Test
//    public void testCarDistanceOutput() {
//        PickRandomNumber pickRandomNumber = new PickRandomNumber();
//        CarRacingStarts carRacingStarts = new CarRacingStarts(pickRandomNumber);
//        CarRaceResultsSave carRaceResultsSave = new CarRaceResultsSave(carRacingStarts); // 빈 값으로 대체
//
//        // Redirect System.out to capture the printed output
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outputStream));
//
//        carRaceResultsSave.carDistanceOutput();
//
//        // Reset System.out
//        System.setOut(System.out);
//
//        // Verify the printed output with Windows-style line endings
//        String expectedOutput = "Car1 : 5\r\nCar2 : 2\r\nCar3 : 4\r\n"; // Windows 스타일의 줄 바꿈 문자인 '\r\n' 사용
//        assertEquals(expectedOutput, outputStream.toString());
//
//    }
//}
//
