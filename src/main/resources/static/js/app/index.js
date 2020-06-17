var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();

        });

        $('#btn-update').on('click', function () {

            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });

        $('#btn-buy').on('click', function () {
            _this.buy();
        });
    },
    save : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            window.location.reload(true);
            window.location.href = 'http://ec2-3-34-71-14.ap-northeast-2.compute.amazonaws.com/#board';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/#board';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    buy : function () {
        var data = {
            item_name: $('#item_name').val(),
            after_berry: $('#after_berry').val()
        };

        var id = $('#item_id').val();
        var email = $('#email').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/shop/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('아이템을 구매하였습니다.');
            window.location.href = '/#shop';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

};


main.init();