package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Application {
    public static class GameStart {
        public GameStart() {
            inputInformations();
        }

        // 값 받기
        private void inputInformations() {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String inputCarNames = Console.readLine();

            CheckNames checkNames = new CheckNames();
            String[] carNameArray = checkNames.returnCarNamesList(inputCarNames);

            if (checkNames.CheckNames(carNameArray) != false) {
                System.out.println("시도할 횟수는 몇 회인가요?");
                String inputNumber = Console.readLine();
                int tryNumber = Integer.parseInt(inputNumber);

                // 시도 횟수 오입력 시 예외처리
                if (tryNumber < 0) {
                    throw new IllegalArgumentException("0보다 큰 숫자를 입력해주세요.");
                } else { // 횟수까지 정상적으로 입력되었으면 생성된 Map을 가져와 for문을 통해 한번에 결과물 출력
                    // Map생성
                    Movements movements = new Movements();
                    Map<String, int[]> carInformationMap = movements.resultOfRacing(carNameArray, tryNumber);
//                    System.out.print("carInformationMap의 keySet : "+carInformationMap.keySet());
//                    System.out.print("carInformationMap 값 : ");
//                    System.out.println(carInformationMap);
                    //출력방법1
//                    for(Map.Entry<String, int[]> entry : carInformationMap.entrySet()){
//                        System.out.println("key: "+ entry.getKey() + " value : "+entry.getValue());
//                    }
                    //출력방법2
//                    for (String i : carInformationMap.keySet()) {
//                        System.out.println("key : " + i);
//                        for (int j = 0; j < tryNumber; j++) {
//                            System.out.println(" value : " + carInformationMap.get(i)[j]);
//                        }
//                    }
                    // PrintResults 출력하기!!
                    PrintResults printResult = new PrintResults();
                    printResult.calculateMove(carInformationMap, tryNumber);
                }
            }
        }

        public static class CheckNames {
            public String[] returnCarNamesList(String inputNames) {
                inputNames = inputNames.replaceAll("\\s", "");
                String[] nameList = inputNames.split(",");
                return nameList;
            }

            public boolean CheckNames(String[] carNamesList) {
                for (String names : carNamesList) {
                    if (names.length() < 0 || names.length() > 6) {
                        throw new IllegalArgumentException("자동차의 이름은 5자이하로 작성해주세요.");
                    }
                }
                return true;
            }

        }

        private static class Movements {
            // Map을 생성, key = 자동차명, value = 시도횟수만큼의 숫자배열, return Map<String, int[]>
            public Map<String, int[]> Movements(String[] nameList, int tryNumber) {
                Map<String, int[]> resultOfRacing = resultOfRacing(nameList, tryNumber);
                return resultOfRacing;
            }

            public Map<String, int[]> resultOfRacing(String[] nameList, int tryNumber) {
                Map<String, int[]> informationMap = new HashMap(); // 자동차들의 정보를 담은 Map
                // List면 내부의 값이 수정되지 않음..!! Array로 수정!!
//                List<Integer> randomNumberArray = new ArrayList<Integer>(tryNumber); // 시도횟수만큼의 숫자배열
//                int[] randomNumberArray = new int[tryNumber]; //원래위치
//                System.out.println("randomNumberArray의 길이 : "+randomNumberArray.length);
//                System.out.print("nameList의 길이"+nameList.length); //정상출력
//                System.out.println("tryNumber의 값은 : "+tryNumber); //정상출력

                for (int i = 0; i < nameList.length; i++) {
                    int[] randomNumberArray = new int[tryNumber]; //수정위치
//                    System.out.print("이름은 : "+nameList[i] + ", 랜덤한 값은 : ");
                    for (int j = 0; j < tryNumber; j++) {
                        int randomNumber = Randoms.pickNumberInRange(1, 9);
                        randomNumberArray[j] = randomNumber;
//                        System.out.print("randomNumberArray의 "+j+"번째 값 : "+randomNumberArray[j]);
                    }
                    informationMap.put(nameList[i], randomNumberArray);
                }
//                for (Map.Entry<String, int[]> entry : informationMap.entrySet()) {
//                    System.out.print("key: " + entry.getKey());
//                    for(int i = 0; i < entry.getValue().length; i++){
//                        System.out.println( " value : " + entry.getValue()[i]);
//                    }
//                }
                return informationMap;
            }
        }

    }

    public static class PrintResults {
        public PrintResults() { }

        public void calculateMove(Map<String, int[]> resultOfRacing, int tryNumber){
            System.out.println("실행 결과");//여기부터닸
            String[] move = new String[resultOfRacing.keySet().size()];
            int[] counts = new int[resultOfRacing.keySet().size()];

            for(int i = 0; i < move.length; i++){
                move[i] = "";
            }
            for(int i = 0; i < tryNumber; i++){
                int j = 0;
                for(Map.Entry<String, int[]> entry : resultOfRacing.entrySet()){
                    System.out.print(entry.getKey() + " : ");
                    if(3 < entry.getValue()[i]){
                        move[j] += "-";
                        counts[j] += 1;
                    }
                    else { move[j] += ""; }
                    System.out.println(move[j]);
                    j++;
                }
                System.out.println("");
            }

            countsWinner(counts);
        }
        public void countsWinner(int[] countsArr){
            int max = Arrays.stream(countsArr).max().getAsInt();
//            System.out.println("max: "+max);
//            System.out.println(Arrays.binarySearch(countsArr,max));

            String a = String.valueOf(Arrays.asList(countsArr).indexOf(max));
            System.out.println(a);

        }
    }

    public static void main(String[] args) {
        GameStart gamestart = new GameStart();
    }
}
