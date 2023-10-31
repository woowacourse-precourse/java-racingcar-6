### 구현 기능 목록
- [x] 경주할 자동차 이름 입력 받기 (inputCarName)
  - [x] 쉼표 기준으로 분리 (splitByComma)
- [x] 시도할 회수 입력 받기 (inputTryNumber)
- [x] 차수별 자동차 전진 현황 출력 (nowRacing)
  - [x] 0~3: 정차
  - [x] 4~9: 한 칸 전진
- [x] 게임 완료 후 우승자 출력 (printWinner)
  - [x] 단독 우승
  - [x] 여러 명 우승: 쉼표로 구분
- [ ] 입력 값이 잘못된 경우 `IllegalArgumentException` 발생시킴
  - [x] 자동차 이름이 6자 이상일 경우 (isLengthZeroOrOverFive)
  - [x] 자동차 이름 입력에 쉼표가 연속으로 들어갈 경우 (isLengthZeroOrOverFive)
  - [x] 자동차 이름이 중복되는 경우 (hasSameCarName)  
  - [x] 자동차 입력 값이 비어있을 경우 (isEmpty)
  - [x] 띄어쓰기가 포함될 경우 (hasSpace)
  - [x] 시도할 회수가 숫자가 아닐 경우 (toNumber)
  - [x] 시도할 회수가 1~1000 이외의 값인 경우 (isNumberOneToThousand)  

  

### 테스트할 내용
-[ ] 자동차 이름 입력
  - [x] 입력값에 띄어쓰기가 있는 경우
  - [x] 자동차 이름이 6자인 경우
  - [x] 동일한 자동차 이름이 있는 경우
  - [x] 입력값이 없는 경우
- [ ] 시도할 회수 입력  
  - [x] 입력값이 0인 경우
  - [x] 입력값에 한글 혹은 영어가 입력될 경우
- [ ] 결과 출력
  - [x] 자동차 입력에 랜덤 문자, 시도할 회수에 랜덤 숫자 입력하여 오류 발생 여부 확인