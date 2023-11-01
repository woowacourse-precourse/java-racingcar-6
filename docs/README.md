### 요구사항
1. 자동차 이름 입력 받기 Game#getRacingCars
- 이름은 쉼표(,)로 구분
- 5자 이하만 가능
2. 시도할 횟수 입력 받기 Game#getRoundCount
- 값은 숫자여야 함

(시도할 횟수만큼 반복)
3. 각 자동차에 대해 0과 9 사이에서 무작위 값 구하기(Randoms 사용) Car#makeRandomNumber
4. 무작위 값이 4 이상이면 전진하기 Car#move
5. 실행 결과 프린트 OutputView#printRoundResult

6. 가장 많이 전진한 자동차 계산 RacingCars#findWinner
7. 우승자 프린트 OutputView#printWinner
- 우승자가 여러 명일 경우 ","를 이용하여 구분



### 이번 미션 목표
1. run 메서드에서 전체 로직이 잘 드러나게 하기
2. 디자인 패턴보다 객체 지향에 집중하기
3. getter와 setter 최대한 덜 쓰기 (2번과 연관)
4. 클래스 최대한 작게 만들기
5. 테스트 코드 mock과 클래스를 사용해서 최대한 효율적으로 작성해보기

### 코드 설명
https://velog.io/write?id=db3d0c84-3ee2-409c-95a0-7720884ef2db
