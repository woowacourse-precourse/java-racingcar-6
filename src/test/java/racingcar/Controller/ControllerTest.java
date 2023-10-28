package racingcar.Controller;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.Service.Service;

class ControllerTest {
    Service service = Mockito.mock(Service.class);
    Controller controller = new Controller(service);


    @Test
    void 시도할_횟수가_5이면_5번_경기를_진행한다() {
        //given
        Mockito.when(service.receiveCars()).thenReturn("test1,test2,test3");
        Mockito.when(service.receiveTryCount()).thenReturn("5");

        //when
        controller.run();

        //then
        Mockito.verify(service, Mockito.times(5)).executeOneGame();
    }

}