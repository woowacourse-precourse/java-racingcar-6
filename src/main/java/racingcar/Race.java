package racingcar;

public class Race{

    RunningMessage message = new RunningMessage();
    CarSetting carSetting = new CarSetting();
    public void start(){
        message.printStartMessage();
        carSetting.setCarName();
    }
}
