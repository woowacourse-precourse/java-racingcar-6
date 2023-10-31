package racingcar.Controller;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.Service.Service;

class ControllerTest {
    Service service = Mockito.mock(Service.class);
    Controller controller = new Controller(service);


    @Test
    void 시도할_횟수가_5이면_5번_경기를_진행한다() {
        //given
        String input = "pobi,woni,jun" + "\n" + "5";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        //when
        controller.run();

        //then
        Mockito.verify(service, Mockito.times(5)).executeOneGame();
    }

}