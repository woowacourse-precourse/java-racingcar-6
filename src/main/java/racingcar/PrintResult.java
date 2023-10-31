package racingcar;

public class PrintResult {

    public void printWinner(int[] locations, String[] names){
        String winnerIdx = findWinnerIdx(locations);
        String[] idxs = splitIdx(winnerIdx);
        for(int i = 0; i < idxs.length; i++){
            int idx = Integer.parseInt(idxs[i]);
            System.out.printf("%s", names[idx]);
            if(i < (idxs.length-1)) System.out.print(", ");
        }
    }

    private String findWinnerIdx(int[] intArr){
        String winner = "";
        int max = findMax(intArr);
        for(int i = 0; i < intArr.length; i++){
            if(intArr[i] == max) {
                winner += Integer.toString(i);
                winner += " ";
            }
        }
        return winner;
    }

    private int findMax(int[] intArr){
        int max = 0;
        for(int i = 0; i < intArr.length; i++){
            if(max < intArr[i]) max = intArr[i];
        }
        return max;
    }

    private String[] splitIdx(String str){
        String[] idx = str.split(" ");
        return idx;
    }

    public void printLocation(int[] locations, String[] names){
        for(int i = 0; i < locations.length; i++){
            printCarLocation(locations[i], names[i]);
        }
        System.out.println();
    }

    private void printCarLocation(int location, String name){
        System.out.print(name + " : ");
        for(int i = 0; i < location; i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
