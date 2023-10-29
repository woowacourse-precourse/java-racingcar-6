# 🚗레이싱카

## 프로그래밍 요구 사항
- indent depth 3 넘지 않도록 구현
- 3항 연산자 사용 금지
- 함수가 한 가지 일만 할 것
- 테스트 코드 작성

## 기능 요구 사항
1. 자동차 이름 입력받기(쉼표로 구분)
2. 시도 횟수 입력받기
3. 전진 조건 : 무작위 값(0~9) 구한 후 4 이상인 경우
4. 게임 종료 후 우승자 출력 (우승자는 1명 이상, 쉼표로 구분)
5. 사용자가 잘못된 값 입력 시 IllegalArgumentException 발생

## 구현 기능 목록
- model
  - [ ] car
     - [ ] distance
     - [ ] name
     - [ ] forward() 
- controller
  - [ ] gameController
    - [ ] playGame 
      - [ ] gameService method
      - [ ] ConsolePrintService method
- service
  - [ ] ConsolePrintService - 화면 출력
  - [ ] gameService
    - [ ] userInput (car, cnt)
    - [ ] randomNumber pick
    - [ ] change car cnt 
- exception
  - [ ] IllegalArgumentException
    - 사용자가 잘못된 값 입력할 경우
    - ..가 있나..?