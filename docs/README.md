순서도
1. 사용자의 입력을 저장한다. 입력은 쉼표를 기준으로 구분한다. / Reader.readInput()
2. 이름 입력 이후에는 몇번 시행하는지에 대한 숫자를 입력받는다. / Reader.readNumber()
- 잘못된 입력의 경우 : 
① 이름이 5자를 초과한 경우
② 숫자가 아닌 경우의 값이 들어온 경우
3. 각 자동차에 대해서 0부터 9까지 무작위 값을 선정한다. / MoveChecker
4. 자동차가 갖는 숫자가 4이상인 경우 전진하고 4미만인 경우 정지한다. / MoveChecker
- 자동차가 전진한 경우 자동차의 index를 확인하고 count의 index에 1을 더한다. / MoveChecker
- 각 자동차의 전진 및 정지가 끝날 때마다 결과를 출력한다. / ResultChecker, MoveChecker
5. 입력받은 숫자만큼 3번과 4번을 반복 시행한다. / MoveChecker
6. 반복 시행이 끝난 경우 우승자를 출력한다. 가장 많이 전진한 플레이어가 우승한다. 가장 많은 수가 두 명 이상인 경우 쉼표를 통해 구분한다. / WinnerChecker, IndexFider
---
커밋 단위
1. Reader를 통해 입력 값 읽는 것 구현
2. Game을 통해 직접 게임한 것 구현
3. 올바른 출력을 위한 Game 리펙토링
4. Game 내에 있는 함수를 클래스로 분리하고 각 클래스와 함수 이름 리펙토링
5. MoveCheckerTester를 생성하여 MoveChecker가 올바른 범위 내에 값을 가진 List를 return하는지 테스트함
6. MaxIndexFinderTester를 생성하여 MaxIndexFinder가 올바른 최대값 인덱스를 return하는지 테스트함
7. ReaderTester를 생성하여 Reader가 올바른 값을 읽어드리는지 테스트함
8. ResultPrinterTester를 생성하여 ResultPrint가 올바른 결과를 출력하는지 테스트함
9. WinnerCheckerTester를 생성하여 WinnerChecker가 올바른 최종 승리자를 출력하는지 테스트함