package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.controller.Controller;
import racingcar.view.Message;


public class UserInputExecutionCntTest {
    @Test
    void 실행횟수_0(){
        String user_input = "0";

        try{
            Controller.convertStringToInteger(user_input);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            Assertions.assertEquals(Message.EXECUTION_INPUT_TYPE_ERROR, e.getMessage());
        }
    }

    @Test
    void 실행횟수_음의_정수(){
        String user_input = "-2";

        try{
            Controller.convertStringToInteger(user_input);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            Assertions.assertEquals(Message.EXECUTION_INPUT_TYPE_ERROR, e.getMessage());
        }
    }

    @Test
    void 실행횟수_양의_정수_정상(){
        String user_input = "2";

        try{
            Controller.convertStringToInteger(user_input);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            Assertions.assertEquals(Message.EXECUTION_INPUT_TYPE_ERROR, e.getMessage());
        }
    }

    @Test
    void 실행횟수_실수(){
        String user_input = "1.1";

        try{
            Controller.convertStringToInteger(user_input);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            Assertions.assertEquals(Message.EXECUTION_INPUT_TYPE_ERROR, e.getMessage());
        }
    }

    @Test
    void 실행횟수_문자열(){
        String user_input = "a";

        try{
            Controller.convertStringToInteger(user_input);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            Assertions.assertEquals(Message.EXECUTION_INPUT_TYPE_ERROR, e.getMessage());
        }
    }

    @Test
    void 실행횟수_아무것도_없음() {
        String user_input = "";

        try {
            Controller.convertStringToInteger(user_input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(Message.EXECUTION_INPUT_TYPE_ERROR, e.getMessage());
        }
    }
}
