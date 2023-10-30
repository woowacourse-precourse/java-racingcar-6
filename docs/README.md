# 구현 계획

## 1주차 피드백

1. PR 닫지 말고 추가 커밋
2. 변수명 의도 드러내도록 투자 - 변수명 컨벤션
3. 변수명 축약 말 것. 중복은 피할 것
4. java에서 제공하는 api - 내가 만들기 전 존재하는지 확인
5. 배열 대신 java Collection 사용

## 기능 요구사항

1. 자동차 이름 , 로 구분
2. 자동차 이름 5자 이하
3. 이동 횟수 필수 작성
4. 전진 조건 4이상
5. 우승자 여러명 , 이용 - String.join()

## 프로그래밍 요구사항

1. java 코드 컨벤션 가이드 준수
2. 들어쓰기, 인덴트 2까지만 허용 - 메서드 분리
    ```java
    public class depth {
        public static void main(String[] args) {
            while(true) { // depth 0
                if(Console.readLine().equals("hello")) {     // depth 1
                    System.out.println("good");  // depth 2
                }
            }
        }
    }
    ```
3. 3항 연산자 사용 금지
4. 1가지 함수는 1가지 일만 하도록 메서드 작성
5. 나의 TDD 수행

## 사용 API

1. `pickNumberInRange()`
2. `readLine()`

## 구현 1 - 작동이 목표

1. 게임 참가자 입력
2. 시도횟수 입력
3. 렌덤 값 출력
4. 게임 종료 후 결과 출력
    1. 실행결과
    2. 최종 우승자

## Test - 4가지 작업 중 할 수 있는 TDD 수행

## 구현 2 - 예외 처리 및 코드 리팩토링 (java code 컨벤션, java api, 변수명)

- Input
    1. 이름은 5자 이하
    2. 사용자가 이동 횟수를 무조건 입력해야함 - 1자리 숫자여야한다.

- 예외 클래스 : 사용자가 잘못된 값 - `IllegalArgumentException`
    1. 이름이 5자 이상인 경우
    2. 사용자가 이동 값을 안 넣은 경우