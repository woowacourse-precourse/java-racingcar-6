https://github.com/woowacourse-precourse/java-racingcar-6

이번 과제에서 중심적으로 적용 해볼 것들
1. SRP Single Responsibility Principle 단일 책임 원칙
2. Singleton 패턴
3. Junit5, AssertJ test code 테스트코드 확인
4. List, Set 등의 Java Collection 사용
5. indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
6. Console.java 내용 카피 getter setter 는 내부 private 통해서 사용?

과제 작업 순서
1. 요구사항 분석
2. 기능 요구사항 분석 (DFD, UCD) (다이어그램 스킵)
3. 도메인 분리, 이름 정하기
4. 클래스, 메소드 설계( 클래스 다이어그램 )
5. 플로우 차트 작업( 함수 전체적으로 작업 후 생략 )
6. 코딩
7. 리팩터링

[1Domain]
Application 전체 게임 작동부
gameControl 게임 컨트롤부
-start 게임 시작
-stop 게임 끝
Car 자동차 관련 메소드 집합 클래스
-setCarName 자료값으로 받은 String 값을 변수에 저장
-getCarName carname 변수를 String으로 리턴
-appendDistance 만약 랜덤값이 맞으면 출력 distance 거리 추가
-getDistance distance 값 반환
[//]: # (User 유저 관련 메소드 집합 클래스) 리팩토링 하면서 삭제
CarDrive 자동차 게임 진행을 위한 클래스
-getCarNames
-driving
-outPutCars
-Winner
GameInput 
-userGameTries 게임 진행 횟수
--exceptionalTry
-userCarNameInput 자동차 이름들
-- validateNameInRange 이름값이 5자 이하인지 체크
-- NameSplit 이름 , 분리
-inputStop console.close
-nameSplit , 쉼표로 이름 분리해서 List<String> 반환
GameOutput
-carNameOutput 자동차 이름 출력 한국어
-carDistance 자동차 이동거리 한국어로
-gameResult 

[2Validate]
vlidateGo 무작위값 4이상인지 체크
-pickNumberInRange
validateNameInRange 이름값이 5자 이하인지 체크
-nameInRange 이름값 범위내인지 확인
--exceptionalCarNameRangeout 5자 초과시 IllegalArgumentException

[//]: # (validateFinish 게임이 끝났는지 확인) 리팩하면서 삭제
validateWinner 게임 다 끝났을 때 우승자 확인
-checkJointWinner 공동우승자 확인
-cars list에 차 이름 입력
-setIntegerDistance distance 최대값 숫자로 반환
-checkJoint winner 공동우승 확인
-winnerAdd winner에 배열 추가

[3Constant]
Enum
-0 9 4 magic numbers
- 경주
- 시도
- 결과
- 진척도
- :
- 최종우승자

[4exceptional]
exceptionalCar
exceptionalTry
exceptionalCarNameRangeout

리팩터링 이후