package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

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
        System.out.println("");
        System.out.println("실행 결과");
        while(tryCount > 0) {
            for(String carName : carNames){
                carInfo.put(carName,carInfo.get(carName)+checkCarCanGo());
                printCurrentCarInfo(carName, carInfo.get(carName));
            }

            System.out.println("");
            tryCount--;
        }

        //3. 우승자 선정 및 출력
        checkWinner(carInfo);
    }

    public static String[] getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = readLine();
        String[] carNames = inputCarNames.split(",");

        if(!checkCarNames(carNames)){
            throw new IllegalArgumentException("자동차 이름을 올바르게 입력하세요.(5자 이하)");
        }

        return carNames;
    }

    public static boolean checkCarNames(String[] carNames){
        for(String carName : carNames){
            if(carName.isEmpty()){
                return false;
            }
            if(carName.length() > 5){
                return false;
            }
        }

        return true;
    }

    public static int getTryCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        String inputTryCount = readLine();

        if(!isNumeric(inputTryCount)){
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
        if(Integer.parseInt(inputTryCount) < 1){
            throw new IllegalArgumentException("1 이상의 숫자를 입력하세요.");
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
        System.out.println("");
    }

    public static void checkWinner(HashMap<String,Integer> carInfo){
        ArrayList<String> winnerList = new ArrayList<>();

        List<String> carInfoKeySet = new ArrayList<>(carInfo.keySet());

        carInfoKeySet.sort(((o1, o2) -> carInfo.get(o2).compareTo(carInfo.get(o1))));
        int winnerLocation = -1;


        for(String carName : carInfoKeySet){
            if(winnerLocation == -1){
                winnerLocation = carInfo.get(carName);
                winnerList.add(carName);
                continue;
            }

            if(winnerLocation != -1 && winnerLocation == carInfo.get(carName)){
                winnerList.add(carName);
            }
            else{
                break;
            }
        }

        System.out.printf("최종 우승자 :");
        for(int i=0; i<winnerList.size(); i++){
            if(i != 0){
                System.out.printf(",");
            }
            System.out.printf(" %s",winnerList.get(i));
        }
    }
}
