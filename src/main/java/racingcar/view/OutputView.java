package racingcar.view;



public class OutputView {
    // "-" 기호를 통해 얼마나 갔는지 RacingRoad 보여주기
    // Winner 보여주기
    private static final String RACING_ROAD = "-";

    public static void printRacingStatus(String carName, int position) {
        System.out.print(carName + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print(RACING_ROAD);
        }
        System.out.println();
    }
    // printWinner 메서드 OutputViewf로 빼야함
//    public static void printWinner(String[] list) {
//        List<String> winners = new ArrayList<>();
//        for (int i = 0; i < list.length; i++) {
//            // maxPosition인 int를 찾아 이와 같은 게 있으면 winner 리스트에 추가
//            if (carPositions.get(i) == maxPosition) {
//                winners.add(list[i]);
//            }
//        }
//        System.out.println("\n최종 우승자 : " + String.join(", ", winners));
//    }

}
