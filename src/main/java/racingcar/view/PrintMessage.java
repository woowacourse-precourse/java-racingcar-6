package racingcar.view;

public class PrintMessage {
    
    String text;

    void printStart(){
        text = Messages.INPUT_START_MESSAGE;
        System.out.println(text);
    }

    void printRound(){
        text = Messages.INPUT_ROUND_MESSAGE;
        System.out.println(text);
    }

    void printPlay(){
        text = Messages.PRINT_ROUND_MESSAGE;
        System.out.println(text);
    }

    void printEnd(){
        text = Messages.PRINT_END_MESSAGE;
        System.out.println(text);
    }
    
}
