package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        application.startGame();
    }

    private static final String CarNamesAlert = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String NumberTryAlert = "시도할 회수는 몇 회인가요?";
    private Map<String, String> carStatus;

    public void startGame(){
        System.out.println(CarNamesAlert);
        String name =readLine();
        String[] carNames = name.split(",");
        CarNameValidate(carNames);

        System.out.println(NumberTryAlert);
        int number = Integer.parseInt(readLine());

        InitalcarSetting(carNames);
        playGame(number);
        winner();
    }

    private void CarNameValidate(String[] carNames){
        for(String carName : carNames){
            if(carName.length()>5){
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private void InitalcarSetting(String[] carNames){
        carStatus = new HashMap<>();
        for(String carName : carNames){
            carStatus.put(carName,"");
        }
    }
    private void playGame(int number){
        for(int i =0; i<number; i++){
            MoveCar();

        }
    }
    private void MoveCar(){
        for(String carName: carStatus.keySet()){
            int rand = Randoms.pickNumberInRange(0,9);
            if(rand>=4){
               carStatus.put(carName,carStatus.get(carName)+"-");
            }
        }
        for (String carName : carStatus.keySet()) {
            System.out.println(carName + " : " + carStatus.get(carName));
        }
        System.out.println();
    }

    private void winner() {
        int max = 0;
        String winners ="";
        for(String carMoves : carStatus.values()){
          if(max< carMoves.length()){
              max = carMoves.length();
          }
        }
        for(String carName : carStatus.keySet()){
          if(carStatus.get(carName).length()==max){
            if(!winners.isEmpty()){
               winners += ",";
            }
            winners +=carName;
          }
        }
        System.out.println("최종 우승자 : " + winners);
    }
}