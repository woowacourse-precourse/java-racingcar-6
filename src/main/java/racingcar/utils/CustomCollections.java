package racingcar.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * {@code CustomCollections} 클래스는 컬렉션을 다루는 사용자 지정 유틸리티 메서드를 제공합니다.
 */
public class CustomCollections {
    private CustomCollections() {
    }

    /**
     * 주어진 컬렉션에서 요소의 <i>자연 순서</i>에 따른 최대 요소 전체 목록을 반환합니다. 컬렉션의 모든 요소는 {@code Comparable} 인터페이스를 구현해야 합니다. 또한, 컬렉션의 모든
     * 요소는 <i>상호 비교 가능</i>해야 합니다 (즉, {@code e1.compareTo(e2)}가 컬렉션 내의 모든 요소 {@code e1} 및 {@code e2}에 대해
     * {@code ClassCastException}을 던지지 않아야 합니다.<p>
     * <p>
     * 이 메서드는 컬렉션 전체를 반복하므로 컬렉션의 크기에 비례하는 시간이 소요됩니다.
     *
     * @param <T>  컬렉션의 객체 클래스
     * @param coll 최대 요소를 찾을 컬렉션
     * @return 주어진 컬렉션의 <i>자연 순서</i>에 따른 컬렉션에서 최대값 요소들의 목록
     * @throws ClassCastException     컬렉션에 <i>상호 비교 가능</i>하지 않은 요소 (예: 문자열과 정수)가 포함된 경우
     * @throws NoSuchElementException 컬렉션이 비어 있는 경우
     * @see Comparable
     */
    public static <T extends Object & Comparable<? super T>> List<T> maxAll(Collection<? extends T> coll) {
        Iterator<? extends T> i = coll.iterator();

        List<T> candidates = new ArrayList<>();

        T max = i.next();

        while (i.hasNext()) {
            T next = i.next();
            if (next.compareTo(max) > 0) {
                max = next;
                candidates.clear();
                candidates.add(next);
            } else if (next.compareTo(max) == 0) {
                candidates.add(next);
            }
        }

        return candidates;
    }
}
