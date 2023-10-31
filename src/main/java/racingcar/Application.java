package racingcar;

import camp.nextstep.edu.missionutils.*;

import java.util.List;

public class Application {
    // 자동차 이름을 입력 받는 함수
    public static String[] inputCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String inputStr = Console.readLine();
        String str = inputStr;

        // 쉼표가 아닌 다른 기호가 들어간 경우
        if(!str.replaceAll(",", "").matches("^[a-zA-Z]*$")){
            throw new IllegalArgumentException();
        }

        String[] carName = inputStr.split(",");

        // 자동차 이름이 5자 이상인 경우 Exception 발생
        for(int i = 0; i<carName.length;i++){
            if(carName[i].length()>=5){
                throw new IllegalArgumentException();
            }
        }
        return carName;
    }


    // 시도할 횟수를 입력받는 함수
    public static int inputTry(){
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            int tryCnt = Integer.parseInt(Console.readLine());
            return tryCnt;
        }
        catch (Exception exception) {
            throw new IllegalArgumentException();
        }
    }


    // 전진 하는 지 아닌 지를 확인하는 함수
    public static boolean isMoveForward(){
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum >= 4;
    }


    // 각 자동차에 따라 전진 상태 확인 
    public static int[] moveForward(String[] carName, int[] carStatus){
        for(int i=0;i<carName.length;i++){
            if(isMoveForward()){
                carStatus[i]++;
            }
            System.out.println(carName[i] + " : " + "-".repeat(carStatus[i]));
        }
        System.out.println();
        return carStatus;
    }

    public static void printResult(){

    }

    public static void main(String[] args) {
        String[] carName = inputCars();
        int carCnt = carName.length;
//        for(int i =0; i < carCnt; i++){
//            System.out.println(carName[i]);
//        }

        int tryCnt = inputTry();
//        System.out.println(tryCnt);

        System.out.println("실행 결과");
        int[] carStatus = new int[carCnt];
        for(int i = 0;i<tryCnt ;i++){
            carStatus = moveForward(carName, carStatus);
        }


    }
}
