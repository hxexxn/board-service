

// // let loginBtn = $('.login-btn');

// // $(loginBtn).click(function(){

// //     var user_id = $('.user_id').val();
// //     var user_pw = $('.user_pw').val();

// //     var login_data = {"user_id" : user_id, "user_pw" : user_pw};

// //     $.ajax({
// //         type: "POST",
// //         url: "/auth/login",
// //         data: login_data,
// //         success: function(result_count) {
// //             if (result_count != 1) {

// //             }
// //         }
// //     })
// // });



// function loginCheck() {
//     $('#user_pw').on("change keyup paste", function() {

//         var user_id= $('#user_id').val();
//         var user_pw = $('#user_pw').val();
    
//         $.ajax({
//             url: '/auth/duplicate/user-info-check',
//             type: 'post',
//             data: {user_id: user_id, user_pw: user_pw},
//             success: function(result_info) {
//                 if (result_info) {
//                     $('.dup-nick').hide();
//                     $('#login-form').submit();
//                 } else {
//                     $('.dup-nick').show();
//                     $('.cdup-nick').html('아이디와 비밀번호가 일치하지 않습니다.');
//                 }
//             }
//         });
    
    
//     });
// };