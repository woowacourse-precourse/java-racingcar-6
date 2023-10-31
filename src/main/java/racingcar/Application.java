package racingcar;

public class Application {
    public static void main(String[] args) {
    	RacingController racing = new RacingController();
    	racing.start();
    	racing.result();
//    	HashMap<String,Integer> carName = new HashMap<>();
//        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
//        String[] inputArr = Console.readLine().split(",");
//        
//        for(int i=0;i<inputArr.length;i++) {
//        	if(inputArr[i].length() > 5)
//        		System.exit(0);
//        	carName.put(inputArr[i], 0);
//        }
//        
//        System.out.println("시도할 회수는 몇회인가요?");
//        int count = Integer.parseInt(Console.readLine());
//       
//        System.out.println("\n실행 결과");
//        for(int i=0;i<count;i++) {
//        	for(int j=0;j<carName.size();j++) {
//        		if(Randoms.pickNumberInRange(0, 9) >= 4)
//        			carName.put(inputArr[j],carName.getOrDefault(inputArr[j], 0) + 1);
//        		String forward = "-".repeat(carName.get(inputArr[j]));
//        		System.out.println(inputArr[j]+" : "+forward);
//        	}
//        	System.out.println();
//        }
//
//        System.out.print("최종 우승자 : ");
//        int winner = Collections.max(carName.values());
//        int winnerCnt = 0;
//        for(int i=0;i<carName.size();i++) {
//        	if(carName.get(inputArr[i]) == winner) {
//        		if(winnerCnt > 1) System.out.print(", "+inputArr[i]);
//        		else System.out.print(inputArr[i]);
//        		winnerCnt++;
//        	}        		
//        }
    }
}
