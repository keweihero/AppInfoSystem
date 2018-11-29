$(function () {
    $('#pageInfo a').click(function () {
        var cur = $(this).attr('cur');
        $('[name = "currentPage"]').val(cur);
        $('[name = "frmSearch"]').submit();
    });
});