$(function() {
    $('#messages p').click(function() {
        $(this).fadeOut();
    });
    setTimeout(function() {
        $('#messages p.info').fadeOut();
    }, 3000);
});