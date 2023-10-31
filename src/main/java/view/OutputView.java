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
    public void printGameMessage(MessageType messageType){
        switch (messageType){
            case GAME_START:
                print(MessageType.GAME_START.getMessage());
                break;
            case TRY_COUNT:
                print(MessageType.TRY_COUNT.getMessage());
                break;
            case PROGRESS_RESULT:
                print(MessageType.PROGRESS_RESULT.getMessage());
                break;
            case CAR_STEP_PROGRESS:
                print(MessageType.CAR_STEP_PROGRESS.getMessage());
                break;
            case FINAL_RESULT:
                print(MessageType.FINAL_RESULT.getMessage());
                break;
        }
    }

}


















