package racingcar.domain.output;

public class Output {

    public static void printMessage(OutputMessage outputMessage){
        System.out.println(outputMessage.message);
    }

    public static void printMessage(OutputMessage outputMessage, String messageValue){
        System.out.printf((outputMessage.message) + "%n", messageValue);
    }

    public static void printResultMessage(OutputMessage outputMessage, String name, String distance){
        System.out.printf((outputMessage.message) + "%n", name, distance);
    }

    public static void printNewLine(){
        System.out.println();
    }
}
