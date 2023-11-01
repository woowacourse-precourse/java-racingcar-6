package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

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

        for (int i = 0; i < carList.size(); i++) {

            //carStatus 에 담기
            RacingCar tmpRacingCar = new RacingCar();
            tmpRacingCar.setCarName(carList.get(i));

            carStatus.add(tmpRacingCar);
        }


        //input 2
        System.out.println("시도할 회수는 몇회인가요?");
        String loofStr = readLine();

        // int 형으로 바꿔 주긴 할건데, '35T'이런건 except 로 보고.. -35 이런건 그냥 바꿔줘야하나 몰겠다
        int loofInt;

        try {
            loofInt = Integer.parseInt(loofStr);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }

        // func2 -> 결과출력
        System.out.println("\n실행 결과");

        for(int tmp =0; tmp<loofInt; tmp++) {

            for (int i = 0; i < carStatus.size(); i++) {
                carStatus.get(i).addWinCount(pickNumberInRange(0, 9));

                String result = carStatus.get(i).carName + " : "+carStatus.get(i).prtWin();

                System.out.println(result);
            }
            System.out.println();

        }

        //Result println

        ArrayList<Integer> countList = new ArrayList<>();

        for(int j=0;j<carList.size();j++){
            countList.add(carStatus.get(j).winCount);
        }

        int maxValue = Collections.max(countList);
        ArrayList<String> winners = new ArrayList<>();

//        System.out.println(maxValue);

        for(int k=0;k<carList.size();k++){
            if (carStatus.get(k).winCount == maxValue){
                winners.add(carStatus.get(k).carName);
            }
        }
        StringJoiner winnersPrt = new StringJoiner(", ");

        for(int r=0;r<winners.size();r++){
            winnersPrt.add(winners.get(r));
        }

        //Result
        String Result = String.format("최종 우승자 : %s",winnersPrt);

        System.out.println(Result);
    }
}


class RacingCar {
    String carName;
    int winCount = 0;
    public void setCarName(String carName){
        this.carName = carName;
    }

    //몇 번 이겼는지 체크 하고
    public void addWinCount(int numb){
        if (numb>3){
            this.winCount++;
        }
    }
    //이긴 상태 출력용
    public String prtWin(){
        String distance = "";

        for(int i=0;i<this.winCount;i++){
            distance = distance.concat("-");
        }
        return distance;
    }
}