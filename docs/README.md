# class1: user input

    method1: labelNameOfCar
        유저의 입력을 받아 변수에 저장
        -> verification.verifyArg 실행
        -> 비정상입력시 IllegalArgumentException

    method2: setupNumberOfTry
        ->자연수입력
        ->0또는 음수, 문자입력시 IllegalArgumentException

# class2: CarImpl (interface - car)

    method1: goOrStop
        random.pickNumberInRange()실핼
        ->4보다 큰지 판단 후 1or0 return

    method2: writeLocation
        goOrStop의 리턴값을 이용해 진행or 정지

    method3: showLocation
        각 객체의 현재위치 출력

# class3: SystemOutput

    method1: showStstus
        게임 진행중 진행과정을 보여줄 메서드
    
    method2: showResult
        게임후 결과출력


# class4: Verification
    
    mothod1: verifyNames

    mothod2: verifyNumberOfTry

# class(main): Application