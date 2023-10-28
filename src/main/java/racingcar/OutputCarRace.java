package racingcar;

public class OutputCarRace{
    public static OutputCarRace print(final MessageType messageType){
        return new OutputCarRace(messageType);
    }

    private OutputCarRace(){}

    private OutputCarRace(final MessageType messageType){
        System.out.println(messageType.getValue());
    }
}
