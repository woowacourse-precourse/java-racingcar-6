package racingcar.view;

public class PrintMessage {
    
    String text;

    public void printStart(){
        text = Messages.INPUT_START_MESSAGE;
        System.out.println(text);
    }

    public void printRound(){
        text = Messages.INPUT_ROUND_MESSAGE;
        System.out.println(text);
    }

    public void printPlay(){
        text = Messages.PRINT_ROUND_MESSAGE;
        System.out.println(text);
    }

    public void printEnd(){
        text = Messages.PRINT_END_MESSAGE;
        System.out.println(text);
    }
    
}
