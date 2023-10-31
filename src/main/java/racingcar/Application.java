package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;


public class Application {
    public static void main(String[] args) {

        //input 1
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = readLine();

        //func1 -> input 정리
        List<String> carList = List.of(userInput.split(","));
        List<RacingCar> carStatus = new ArrayList<>();

        for(int i=0;i<carList.size();i++){

            //carStatus 에 담기
            RacingCar tmpRacingCar = new RacingCar();
            tmpRacingCar.setCarName(carList.get(i));

            carStatus.add(tmpRacingCar);
        }


        //input 2
        System.out.println("시도할 회수는 몇회인가요?");
        String loofStr = readLine();

        // int 형으로 바꿔 주긴 할건데, '35T'이런건 except 로 보고.. -35 이런건 그냥 바꿔줘야하나 몰겠다
        try{
            int loofInt = Math.abs(Integer.parseInt(loofStr));
        }catch(NumberFormatException ex){
            throw new IllegalArgumentException();
        }

        // func2 -> 결과출력
        System.out.println("실행 결과");

        while(loofInt){
            loofInt--;

            for (int i=0;i<carStatus.size();i++){
                carStatus.get(i).addWinCount(pickNumberInRange(0,9));
                System.out.println(String.format())
            }

        }


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