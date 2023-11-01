1. [V]경주 할 자동차 이름 입력받기 StartCondition#inputCarName()
    - [V]쉼표기준 구분 StartCondition#checkInputCarName()
    - [V]5자이하 이름 StartCondition#ckeckInputCarName()
2. [V]시도 횟수 입력받기 StartCondition#inputAttemptNumber()
    - [V]숫자만 입력 가능하게 하기 StartCondition#checkAttemptNumber()
3. [V]각 자동차의 움직임 판단하기 JudgeMovement
    - [V]0에서 9 중 무작위 숫자를 자동차 수만큼 만들기 JudgeMovement#creatRandomNumber()
    - [V]생성된 숫자를 각 자동차에 배치하고 배치된 숫자가 4이상이면 전진 JudgeMovement#moveForward()
4. [V]결과 출력하기 Result
    - [V]경기 결과 출력하기 Result#printRapResult()
    - [V]전진한 칸수 출력하기 Result#printCarPosition()
    - [V]우승자 선정하기 Result#pickWinners()
    - [V]우승자 출력하기 Result#printWinner()