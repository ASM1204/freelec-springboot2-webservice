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

        $('#btn-select').on('click', function () {
            _this.select();
        });

        $('#btn-trade').on('click', function () {
            _this.trade();
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
            window.location.href = '/#board';
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
            item_berry: $('#item_berry').val()
        };

        var id = $('#item_id').val();

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
            alert('아이템을 구매하였습니다.');
            window.location.href = '/#shop';
        });
    },
    select : function () {

        var items = document.getElementsByName('item_my_count');
        var item_image_list = document.getElementsByName('item_image_list');
        var item_name_list = document.getElementsByName('item_name_list');
        var item_type_list = document.getElementsByName('item_type_list');
        var item_id_list = document.getElementsByName('item_id_list');

        for(var i = 0; i < items.length; i++){
            if(items[i].checked == true){
                switch(parseInt(items[i].value)){
                    case 0:
                        alert('@ ' + items[i].val + ' @ 보유수량이 너무 적습니다!');
                        break;

                    default:

                        var data = {
                            item_name: item_name_list[i].value,
                            item_image: item_image_list[i].value,
                            item_type: item_type_list[i].value,
                            item_price: $('#sell_price').val(),
                            author: $('#select_my_email').val()
                            };

                        $.ajax({
                            type: 'POST',
                            url: '/api/v1/auction',
                            dataType: 'json',
                            contentType:'application/json; charset=utf-8',
                            data: JSON.stringify(data)
                        }).done(function() {
                            window.location.href = '/#auction';
                        }).fail(function (error) {
                            alert(JSON.stringify(error));
                            window.location.href = '/#auction';
                        });

                        var data_ = {
                            item_name: item_name_list[i].value
                            };

                        $.ajax({
                            type: 'PUT',
                            url: '/api/v1/auction',
                            dataType: 'json',
                            contentType:'application/json; charset=utf-8',
                            data: JSON.stringify(data_)
                        });
                    break;
                }
            }
        }
    },
    trade : function () {

            var item_price = $('#auction_item_price').val();
            var berry = $('#auction_my_berry').val();

            if(item_price <= berry){
                var data = {
                    item_name: $('#auction_item_name').val(),
                    item_berry: $('#auction_item_price').val()
                };

                var id = $('#item_id').val();

                $.ajax({
                    type: 'PUT',
                    url: '/api/v1/auction/'+id,
                    dataType: 'json',
                    contentType:'application/json; charset=utf-8',
                    data: JSON.stringify(data)
                }).done(function() {
                    alert('아이템을 구매하였습니다.');
                    window.location.href = '/#auction';
                }).fail(function (error) {
                    alert('아이템을 구매하였습니다.');
                    window.location.href = '/#auction';
                });

//                var data_ = {
//                    email: $('#auction_author').val(),
//                    item_berry: $('#auction_item_berry').val()
//                };
//                $.ajax({
//                    type: 'PUT',
//                    url: '/api/v1/auction/'+id,
//                    dataType: 'json',
//                    contentType:'application/json; charset=utf-8',
//                    data: JSON.stringify(data)
//                }).done(function() {
//                    alert('아이템을 구매하였습니다.');
//                    window.location.href = '/#auction';
//                }).fail(function (error) {
//                    alert('아이템을 구매하였습니다.');
//                    window.location.href = '/#auction';
//                });
            }else{
                alert('소지한 Berry가 부족합니다.');
            }
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