function msg(msg) {
    new NoticeJs({
        text: msg,
        position: 'topCenter',
        animation: {
            open: 'animated bounceInRight',
            close: 'animated bounceOutLeft'
        }
    }).show();
}