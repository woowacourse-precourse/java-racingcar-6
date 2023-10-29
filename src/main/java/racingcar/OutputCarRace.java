package racingcar;

import static java.lang.String.format;

public class OutputCarRace{
    public static OutputCarRace print(final MessageType messageType){
        return new OutputCarRace(messageType);
    }

    public static OutputCarRace printf(final MessageType messageType, final Object... inputNames){
        return new OutputCarRace(messageType, inputNames);
    }

    private OutputCarRace(){}

    private OutputCarRace(final MessageType messageType){
        String message = messageType.getValue();

        printMessage(message);
    }

    private OutputCarRace(final MessageType messageType, final Object... inputNames){
        String message = messageType.getValue();

        printMessage(format(message, inputNames));
    }

    private static void printMessage(String message){
        System.out.println(message);
    }
}
