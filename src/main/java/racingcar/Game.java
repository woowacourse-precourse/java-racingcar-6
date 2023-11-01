package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class Game {

    public static void start(){
        //1. 사용자로부터 자동차 이름, 시도할 회수 입력받기
        HashMap<String,Integer> carInfo = new HashMap<>();
        String[] carNames = getCarNames();
        int tryCount = getTryCount();

        for(String carName : carNames){
            carInfo.put(carName,0);
        }

        //2. 0에서 9사이에서 무작위 값을 구한 후 무작위 값이 4이상일 경우 해당 자동차를 전진시키는 기능
        while(tryCount > 0) {
            for(String carName : carNames){
                carInfo.put(carName,carInfo.get(carName)+checkCarCanGo());
                printCurrentCarInfo(carName, carInfo.get(carName));
            }

            System.out.println("");
            tryCount--;
        }
    }

    public static String[] getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = readLine();

        if(!checkCarNames(inputCarNames)){
            throw new IllegalArgumentException("자동차 이름을 입력하세요.");
        }

        return inputCarNames.split(",");
    }

    public static boolean checkCarNames(String carNames){
        if(carNames.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    public static int getTryCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        String inputTryCount = readLine();

        if(!isNumeric(inputTryCount)){
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }

        return Integer.parseInt(inputTryCount);
    }

    public static boolean isNumeric(String tryCount){
        try {
            Integer.parseInt(tryCount);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    /* 차가 전진할 수 있으면 1을, 없으면 0을 반환 */
    public static int checkCarCanGo(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if(randomNumber >= 4) {
            return 1;
        }
        else{
            return 0;
        }
    }

    public static void printCurrentCarInfo(String carName, int currentCarLocation){
        System.out.printf("%s : ",carName);
        while(currentCarLocation > 0){
            System.out.printf("-");
            currentCarLocation--;
        }
        System.out.printf("\n");
    }
}
