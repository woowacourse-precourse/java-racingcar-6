## 기능 목록
1. n대의 자동차 입력
    - 각 자동차에 이름 부여
    - 쉼표 (,)를 기준으로 구분
    - 자동차의 이릉은 5자 이하
2. 시도할 횟수 입력
3. random값에 의해 자동차 전진
   - 무작위의 값 (0~9사이)이 4이상일 경우 전진
4. 결과 출력
   - 각 차수별, 자동차 이름 : 전진 상태 출력
   - 우승자 출력
     - 우승자가 2명 이상인 경우, 쉼표(,)로 구분하여 출력


## 어떻게 구현할 것인가
- main() 함수
  - 자동차 이름 변수 : carName
  - 자동자 전진 상태 변수 : carStatus
  - 시도할 횟수 변수 : try
  1. inputCars()
  2. inputTry()
  3. moveForward() -> try 만큼
  4. printResult()
  5. 종료

- inputCars() 함수
  - 자동차 입력
    - exception
      - 자동차의 이름이 6자 이상인 경우
      - 쉼표(,)를 기준으로 구분되지 않는 경우

- inputTry() 함수
  - 시도할 횟수 입력
    - exception
      - int형이 아닌 경우

- moveForward() 함수
  - random 값 설정 (0~9)
  - random 값이 4 이상인 경우 전진, 아니면 그대로 
    - 4이상 이면 해당 자동차의 carStatus++
  - 각 자동차의 전진 상태 출력

- printResult() 함수 
  - 최종 우승자 출력