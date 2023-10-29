package racingcar.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class CustomCollectionsTest {
    @Test
    void maxAll_확인() {
        // Given: 정수 컬렉션
        List<Integer> intList = new ArrayList<>();
        intList.add(3);
        intList.add(5);
        intList.add(1);
        intList.add(5);
        intList.add(2);

        // When: maxAll 메서드 호출
        List<Integer> result = CustomCollections.maxAll(intList);

        // Then: 최대값 요소들의 목록 확인
        assertEquals(2, result.size());
        assertEquals(5, result.get(0));
        assertEquals(5, result.get(1));
    }

    @Test
    void maxAll_빈_컬렉션_예외_처리() {
        // Given: 빈 컬렉션
        List<Integer> emptyList = new ArrayList<>();

        // Then: 빈 컬렉션에서 예외 발생을 확인
        assertThrows(NoSuchElementException.class, () -> CustomCollections.maxAll(emptyList));
    }

    @Test
    void maxAll_요소_하나() {
        // Given: 단일 요소 컬렉션
        List<Integer> singleElementList = new ArrayList<>();
        singleElementList.add(42);

        // When: maxAll 메서드 호출
        List<Integer> result = CustomCollections.maxAll(singleElementList);

        // Then: 최대값 요소들의 목록 확인 (하나의 요소가 있어야 함)
        assertEquals(1, result.size());
        assertEquals(42, result.get(0));
    }
}