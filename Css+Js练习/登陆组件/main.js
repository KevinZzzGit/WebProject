let boxState = 'login';
$('#loginBox-changeBtn').click(function () {

    while (!$('#loginBox-changeBtn').is(':animated') && !$('#loginBox #loginBox-shade').is(':animated')) {


        if (boxState === 'login') {
            //  进行短剑的变化
            $('#loginBox-changeBtn').css({
                'transform': 'rotate(225deg)',
            })
            // 因为动画不能设置多个，所以需先确保当前动画状态，或直接删除

            $('#loginBox-changeBtn').css({
                'animation': 'none',
            })
            $('#loginBox-changeBtn').animate({
                left: '420px',
            }, 2000)

            //进行遮罩框的变化
            console.log('触发onclick-login')
            $('#loginBox #loginBox-shade').animate({
                left: '0px',
            }, 2000, function () {
                boxState = 'register';

                $('#loginBox-changeBtn').css({
                    'animation': 'none',
                    'animation': 'BtnRight 1.1s linear infinite',
                })
            })

        } else {

            //  进行短剑的变化
            $('#loginBox-changeBtn').css({
                'transform': 'rotate(45deg)'
            })
            $('#loginBox-changeBtn').css({
                'animation': 'none',
            })
            $('#loginBox-changeBtn').animate({
                left: '20px',
            }, 2000)

            //进行遮罩框的变化
            console.log('触发onclick-register')
            $('#loginBox #loginBox-shade').animate({
                left: '500px',
            }, 2000, function () {
                boxState = 'login';
                $('#loginBox-changeBtn').css({
                    'animation': 'BtnLeft 1.1s linear infinite',

                })
            })
        }
    }
})