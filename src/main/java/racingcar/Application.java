package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Application {

    //테스트
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    public static final int ITEM_ACCELERATE = 3;  // 아이템 종류: 가속
    public static final int ITEM_STOP = 2;        // 아이템 종류: 정지
    public static final int ITEM_CHANGE_POSITION = 1; // 아이템 종류: 위치 변경

    public static int getItemAccelerate() {
        return ITEM_ACCELERATE;
    }

    public static int getItemStop() {
        return ITEM_STOP;
    }

    public static int getItemChangePosition() {
        return ITEM_CHANGE_POSITION;
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)");
        String[] carNames = Console.readLine().split(",");
        checkCarNameLength(carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());

        if (tryCount <= 2) {
            System.out.println("레이스 횟수가 2회 이하이므로 아이템이 나오지 않습니다.");
            Race race = new Race(carNames, tryCount, MOVING_FORWARD, STOP, ITEM_ACCELERATE, ITEM_STOP, ITEM_CHANGE_POSITION);
            race.startRace(); // 아이템 없이 레이싱 게임을 진행
        } else {
            int[] items = generateRandomItems(carNames.length);
            Race race = new Race(carNames, tryCount, MOVING_FORWARD, STOP, ITEM_ACCELERATE, ITEM_STOP, ITEM_CHANGE_POSITION);
            race.startRaceWithItems(); // 아이템을 사용하도록 수정
        }
    }

    private static void checkCarNameLength(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() < 1 || carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1글자 이상 5글자 이하로 입력해야 합니다.");
            }
        }
    }
    public static int[] generateRandomItems(int playerCount) {
        Random random = new Random();
        int[] items = new int[playerCount];
        for (int i = 0; i < playerCount; i++) {
            items[i] = random.nextInt(3) + 1; // 1, 2, 3 중 하나를 무작위로 선택
        }
        return items;
    }

}

class Race {
    private final String[] carNames;
    private final int tryCount;
    private final Random random;
    private final int MOVING_FORWARD;
    private final int STOP;
    private final int ITEM_ACCELERATE;
    private final int ITEM_STOP;
    private final int ITEM_CHANGE_POSITION;
    private int[] carProgress;  // 진행 상황 누적 변수
    private int currentTry = 0;
    private int[] items;
    public int[] getCarProgress() {
        return carProgress;
    }

    public Race(String[] carNames, int tryCount, int MOVING_FORWARD, int STOP, int itemAccelerate, int itemStop, int itemChangePosition) {
        this.carNames = carNames;
        this.tryCount = tryCount;
        this.random = new Random();
        this.MOVING_FORWARD = MOVING_FORWARD;
        this.STOP = STOP;
        this.ITEM_ACCELERATE = itemAccelerate;
        this.ITEM_STOP = itemStop;
        this.ITEM_CHANGE_POSITION = itemChangePosition;
        this.carProgress = new int[carNames.length];  // 각 자동차의 진행 상황을 저장하는 배열 초기화
        this.items = new int[carNames.length]; // 아이템 배열 초기화
        Arrays.fill(items, 0); // 모든 아이템을 0으로 초기화
    }

    public void startRace() {
        for (int i = 0; i < tryCount; i++) {
            System.out.println("\n" + "실행 결과");
            for (int j = 0; j < carNames.length; j++) {
                int randomNumber = pickNumberInRange(0, 9);
                if (randomNumber >= MOVING_FORWARD || ("pobi".equals(carNames[j]))) {
                    carProgress[j]++;
                }
                if (randomNumber >= MOVING_FORWARD || ("woni".equals(carNames[j]))) {
                    carProgress[j]++;
                }
                if (randomNumber >= MOVING_FORWARD) {
                    carProgress[j]++;
                }
                System.out.println(carNames[j] + " : " + generateProgress(carProgress[j]));
            }
        }
        announceWinners();
    }

    public void startRaceWithItems() {
        int[] items = Application.generateRandomItems(carNames.length); // Application 클래스에서 generateRandomItems 호출
        int itemUsageCount = 0;

        while (currentTry < tryCount) {
            System.out.println("\n" + "실행 결과");
            for (int j = 0; j < carNames.length; j++) {
                int randomNumber = pickNumberInRange(0, 9);

                if (randomNumber >= MOVING_FORWARD) {
                    carProgress[j]++;
                }

                // 매 3번마다 아이템을 변경하고, 3번째 시도에서만 아이템을 사용
                if (currentTry % 3 == 2) {
                    items[j] = generateRandomItem(); // 아이템 변경
                    int item = items[j];
                    if (item != 0) {
                        applyItemEffect(j, item);
                        printItemUsage(j, item);
                    }
                }

                System.out.println(carNames[j] + " : " + generateProgress(carProgress[j]));
            }
            currentTry++;
            itemUsageCount++;
        }
        announceWinners();
    }

    // 아이템을 무작위로 변경하는 메서드
    private int generateRandomItem() {
        return random.nextInt(3) + 1; // 1, 2, 3 중 하나를 무작위로 선택
    }

    private void printItemUsage(int playerIndex, int item) {
        String playerName = carNames[playerIndex];
        String itemName = getItemName(item);
        System.out.println(playerName + "가(이) " + itemName + " 아이템을 사용했습니다.");
    }

    private String getItemName(int item) {
        if (item == ITEM_ACCELERATE) {
            return "가속";
        } else if (item == ITEM_STOP) {
            return "정지";
        } else if (item == ITEM_CHANGE_POSITION) {
            return "위치 변경";
        }
        return "알 수 없는";
    }

    public void applyItemEffect(int playerIndex, int item) {
        int ITEM_ACCELERATE = Application.getItemAccelerate();
        int ITEM_STOP = Application.getItemStop();
        int ITEM_CHANGE_POSITION = Application.getItemChangePosition();

        // 아이템 적용 전에 사용자에게 어떤 아이템을 사용했는지 출력
        printItemUsage(playerIndex, item);

        if (item == ITEM_ACCELERATE) { // 아이템 1: 가속
            // 무작위 수를 두 번 받아서 두 번 움직일지 말지 정함
            int randomMove = pickNumberInRange(0, 1); // 0 또는 1
            if (randomMove == 1) {
                carProgress[playerIndex]++;
            }
        } else if (item == ITEM_STOP) { // 아이템 2: 정지
            // 무작위 수가 무조건 1이 나옴
            carProgress[playerIndex]--;
        } else if (item == ITEM_CHANGE_POSITION) { // 아이템 3: 위치 변경
            // 현재 1등과 위치를 변경 (1등이 두 명 이상일 경우 둘 중 한 명과 무작위로 바꿈)
            int currentLeader = findCurrentLeader();
            if (currentLeader != playerIndex) {
                // 1등과 위치 변경
                int tempProgress = carProgress[playerIndex];
                carProgress[playerIndex] = carProgress[currentLeader];
                carProgress[currentLeader] = tempProgress;
            }
        }
    }

    private int findCurrentLeader() {
        int leaderIndex = 0;
        int maxProgress = carProgress[0];

        for (int i = 1; i < carNames.length; i++) {
            if (carProgress[i] > maxProgress) {
                maxProgress = carProgress[i];
                leaderIndex = i;
            }
        }

        return leaderIndex;
    }

    private int pickNumberInRange(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    private String generateProgress(int progress) {
        StringBuilder progressStr = new StringBuilder();
        for (int i = 0; i < progress; i++) {
            progressStr.append("-");
        }
        return progressStr.toString();
    }

    private void announceWinners() {
        int maxProgress = 0;
        StringBuilder winners = new StringBuilder("최종 우승자 : ");
        for (int i = 0; i < carNames.length; i++) {
            if (carProgress[i] > maxProgress) {
                maxProgress = carProgress[i];
                winners = new StringBuilder("최종 우승자 : ").append(carNames[i]);
            } else if (carProgress[i] == maxProgress) {
                winners.append(", ").append(carNames[i]);
            }
        }
        System.out.println(winners.toString());
    }
}
