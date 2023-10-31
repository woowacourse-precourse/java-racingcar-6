package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static final String MOVE_SYMBOL = "-";
    private static final int RANDOM_THRESHOLD = 3;
    private static final int RANDOM_MINRANGE =  0;
    private static final int RANDOM_MAXRANGE  = 9;

      /**
     * 프로그램이 시작하는 Main 함수 입니다.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        ArrayList<String> userlist = isNamesInput();
        System.out.println("시도할 회수는 몇회인가요?");
        int count = isNumberInput();

        System.out.println("실행 결과");
        List<String> winner = startRacing(userlist, count);
        
        if (winner.size() <= 0) {
            throw new IllegalArgumentException("우승자가 없습니다.");
        }

        System.out.print("최종 우승자 : ");
        System.out.print(winner.get(0));
        int index = 1;
        if (winner.size() > 1) {
            System.out.print(", " + winner.get(index++));
        }
        
    }

    /** 레이싱을 시뮬레이션 하는 메서드입니다.
     * 
     * makeHashMap() 메서드로 각 유저에 맞는 HashMap을 만듭니다. 
     * 각 유저가 얼마나 나갔는지는 status의 문자열에 "-"를 추가하며 계산합니다.
     * 출발 할지 안할지는 shouldStart()로 결정합니다.
     * printUsers()는 현재 모든 유저들의 레이싱 상태를 출력합니다.
     * 
     * @param userlist 사용자가 입력한 유저 리스트 입니다.
     * @param count 사용자가 입력한 경기 횟수 입니다.
     * @return 경기가 끝나고 HashMap을 getLongestUsers()로 넘겨 가장 긴 유저들을 찾습니다.
     */
    public static ArrayList<String> startRacing(ArrayList<String> userlist, int count) {
        HashMap<String, String> userStatusMap = makeHashMap(userlist);

        for (int i = 0; i < count; i++) {
            for (String user : userlist) {
                String status = userStatusMap.get(user);
                userStatusMap.put(user, shouldStart(status));
            }
            printUsers(userStatusMap);
        }

        return getLongesetUsers(userStatusMap);
    }

    /** startRacing()으로부터 나온 Map 중에 가장 멀리간 유저들을 찾는 메서드입니다.
     * 
     * @param userStatusMap startRacing()로부터 만들어진 레이싱 결과 Map
     * @return 가장 멀리간 유저들의 리스트를 return 합니다.
     */
    public static ArrayList<String> getLongesetUsers(HashMap<String, String> userStatusMap) {
        int longest = 0;
        ArrayList<String> winners = new ArrayList<>();

        for (String key : userStatusMap.keySet()) {
            String status = userStatusMap.get(key);
            int length = status.length();
            if (length > longest) {
                winners.clear();
                winners.add(key);
                longest = length;
            } else if (length == longest) {
                winners.add(key);
            }
        }

        return winners;
    }


    /** 입력 받은 List를 HashMap으로 초기화 하는 메서드입니다.
     * 
     * @param userlist 사용자로부터 입력받은 User 목록
     * @return User 목록을 key로 갖는 빈 문자열을 갖는 HashMap 입니다.
     */
    public static HashMap<String, String> makeHashMap(ArrayList<String> userlist) {
        HashMap<String, String> userStatusMap = new HashMap<>();

        for (String user : userlist) {
           userStatusMap.put(user, "");
        }
        return userStatusMap;
   }

   /** Randoms를 활용한 전진 유무 체크 및 문자열 갱신
     * 
     * @param status 어떤 유저의 현재 레이싱 상태를 받아옵니다.
     * @return 랜덤 확률로 "-" 를 추가하거나 하지 않은 String을 return 합니다.
     */
    public static String shouldStart(String status) {
        int random = Randoms.pickNumberInRange(RANDOM_MINRANGE, RANDOM_MAXRANGE);

        if (random > RANDOM_MAXRANGE || random < RANDOM_MINRANGE) 
            throw new IllegalArgumentException("랜덤 값의 인수가 잘못되었습니다.");
        
        if (random > RANDOM_THRESHOLD) 
            return status + "-";
             
        return status;
    }

    /** 입력과 관련된 메서드 입니다.
     * 
     * @return inputlist 는 사용자에게 입력 받은 유저 리스트를 return합니다.
     */
    public static ArrayList<String> isNamesInput() {
        
        String input = Console.readLine().trim();
    
        if (input.equals("") || input == null || input.isEmpty()) 
            throw new IllegalArgumentException("입력이 되지 않았습니다.");
        
        StringTokenizer st = new StringTokenizer(input, ",");
        ArrayList<String> inputlist = new ArrayList<>();

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.length() <= 0 || token.length() > 4) {
                throw new IllegalArgumentException("올바른 이름을 입력하세요.");
            }
            inputlist.add(token);
        }

        return inputlist;
    }

    /** 입력과 관련된 메서드 입니다.
     * 
     * @return input은 사용자가 입력한 숫자 입니다.
     */
    public static int isNumberInput() {
        int input = Integer.parseInt(Console.readLine());
        if (input < 0) 
            throw new IllegalArgumentException("음수가 입력되었습니다.");
        
        return input;
    }

    /** 현재 user들의 레이싱 상태를 표시합니다.
     * 
     * @param userStatushMap 현재 레이싱 중인 HashMap입니다.
     */
    public static void printUsers(HashMap<String, String> userStatushMap) {
        Set<String> keySet = userStatushMap.keySet();

        for (String key : keySet) {
            System.out.println(key + " : " + userStatushMap.get(key));
        }
        System.out.println();
    }
}
