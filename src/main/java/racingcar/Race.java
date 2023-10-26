package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Race{
    int trial;

    RunningMessage message = new RunningMessage();
    CarSetting carSetting = new CarSetting();
    public void start(){
        message.printStartMessage();
        carSetting.setCarName();
    }
    public void setTrial(){
        trial = Integer.parseInt(Console.readLine());
    }
}
