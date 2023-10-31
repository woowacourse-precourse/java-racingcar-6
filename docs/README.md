# class1: UserInput

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

    method1: showStatus
        게임 진행중 진행과정을 보여줄 메서드
    
    method2: showResult
        게임후 결과출력


# class4: Verification
    
    mothod1: verifyArg

    mothod2: verifyNumberOfTry

# class5: Grandprix

    method1: PlayGrandprix
        게임의 실질적인 플레이 흐름을 관리

# class(main): Application

# 계획한 기능 이외에 추가로 작성한 기능 목록

    Class:
        -Grandprix
            처음 계획한 바와 다르게 전체적인 게임의 흐음을 main nethod에서 진행하지 않고
            Grandprix클래스를 만들어 내부의 playGrandprix 메서드를 통해 진행하도록 수정함.

    method:
        -showLocation -> getLocation
            게임진행 각 시행을 반복할 때 마다 각자의 객체에서 현재위치 표시하려던계획
            ->location값만 return하고 SystemOutput에서 모든 출력에 관한 기능을
            수행하도록 수정함

        -verifyDuplication
            참가자 이름의 중복에 관한 검증과 Excption케이스를 추가함

    ENUM:
        -EXCEPTIONS
            각 Excption발생시 잘못된 점을 출력하는 값을 저장하고 호출할 메세지를 Enum으로
            관리하도록함