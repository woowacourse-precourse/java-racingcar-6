package view;

import constants.MessageType;

/**
 * Model 의 데이터를 사용자가 보면 화면에 표출하는 클래스
 *
 * @author Ellie
 */
public class OutputView {

    /***
     *사용자에게 메세지를 출력하는 메소드
     *
     * @param message
     */
    public void print(String message){
        System.out.println(message);
    }


    /***
     *사용자에게 메세지 타입에 알맞은 레이싱 메세지를 출력하는 메소드
     *
     * @param messageType
     * @return gameMessage
     */
    public String getGameMessage(MessageType messageType){
        String gameMessage = "";
        switch (messageType){
            case GAME_START -> gameMessage = MessageType.GAME_START.getMessage();
            case TRY_COUNT -> gameMessage = MessageType.TRY_COUNT.getMessage();
            case PROGRESS_RESULT -> gameMessage = MessageType.PROGRESS_RESULT.getMessage();
            case CAR_STEP_PROGRESS -> gameMessage = MessageType.CAR_STEP_PROGRESS.getMessage();
            case FINAL_RESULT -> gameMessage = MessageType.FINAL_RESULT.getMessage();
        }
        return gameMessage;
    }

}


















