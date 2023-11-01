package racingcar;
import static camp.nextstep.edu.missionutils.Console.readLine;
public class Input {
    private String[] cars;
    private int executeCount;
    public void getCarInfo(String input){
        cars= input.split(",");

    }
    public void getInfoExecuteCountInfo(String input){
        executeCount=Integer.parseInt(input);
        System.out.println("");
    }
    public String[] getCars(){
        return cars;
    }
    public int getExecuteCount(){
        return executeCount;
    }
}
