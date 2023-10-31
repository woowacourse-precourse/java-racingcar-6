package racingcar;

import java.util.*;

public class Sorting { //정렬을 해주는 클래스
    private List<Map.Entry<String, String>> WinnerSorting = new ArrayList<>();
    private List <String> WinnerList= new ArrayList<>();

    public List<String> Winner(LinkedHashMap<String, String> GameInfoMap){

        WinnerSorting = new ArrayList<>(GameInfoMap.entrySet());
        Collections.sort(WinnerSorting, (entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        MakeWinnerList();
        return WinnerList;

    }

    private void MakeWinnerList(){

        for (Map.Entry<String, String> entry : WinnerSorting) {
            String key = entry.getKey();
            String value = entry.getValue();

            int valueSize = value.length();
            int MaxValueSize = GetMaxValueSize();

            if (!WinnerList.isEmpty() && valueSize < MaxValueSize) {
                break;
            }

            WinnerList.add(key);
        }

    }

    private int GetMaxValueSize(){

        Map.Entry<String, String> entry =  WinnerSorting.get(0);
        String value = entry.getValue();
        return value.length();

    }

}
