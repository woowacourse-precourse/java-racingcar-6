package racingcar;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        //input 1
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = readLines();

        //func1 -> input 정리해서 생성
        ArrayList<String> carList = userInput.split(",");


        for (i==0;i<size(carList);i++){

        }

        RacingCar tmp = new RacingCar();
        tmp.setCarName("hellow");
        System.out.print(String.format("%s",tmp.carName));
    }
}


class RacingCar {
    String carName;
    int winCount = 0;
    public void setCarName(String carName){
        this.carName = carName;
    }

    public void addWinCount(int numb){
        if (numb>3){
            this.winCount++;
        }
    }
}