package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.drive.Drive;

import static org.assertj.core.api.Assertions.assertThat;

class DriveTest {
    @Test
    void lapsToDriveTest() {
        // Given
        Drive drive = new Drive();
        String input = "5";

        // When
        int result = drive.lapsToDrive(input);

        // Then
        assertThat(result).isBetween(0, 5);
        System.out.println(result);
    }

//    @Test
//    void forwardTest() {
//        // Given
//        Drive drive = new Drive();
//        int input = 5;
//
//        // Then
//        drive.forward(input);
//    }
}
