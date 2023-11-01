### 구현 기능 목록 정리
1. 입력
    - Console API 입력 
    - Random 값 추출 (pickNumberInRange() 활용)
   
2. 테스트 코드
3. 구현 
    - 입력 받기
      1. 쉼표 기준 (inputCarName)
          - 정상 조건
              - Console로 쉼표 기준으로 입력 받기
          - 예외 조건
            - [X] 중복 되는 이름이 있을 경우 예외 처리 (duplicateName)
            - [X] 이름이 5글자 이상일 경우 예외 처리 (checkLength)
            - [X] 쉼표를 안 넣었을 경우 예외 처리 (checkExpression)
            - [X] 숫자 입력시 예외 처리 (isNumberic)

      2. 시도할 횟수 (inputCount)
         - 정상 조건
             - Console로 입력 받기
         - 예외 조건
             - [X] 숫자가 아닌 경우 예외 처리 (checkIsDigit)
             - [X] 음수인 경우 예외 처리 (checkNegative)

   - 전진 조건(createRandom)
     - 정상 조건
       - Random 값 이용하여 무작위 값 구하기
       - 나온 무작위 값이 4 이상일 경우
     - 예외 조건
        - 나온 무작위 값이 4 이하인 경우

   - 출력(output)
     - 우승자가 여러 명일 경우 쉼표(,) 이용 구분
     - 만약 우승자가 한명이면 그냥 출력
     
4. 전체 예외 처리 → IllegalArgumentException


### 확인해야 할 추가 사항
1. indent depth 3이 넘지 않도록 구현
2. 함수가 한가지 일만 하도록 최대한 작게 만들기
3. 테스트 코드 구현