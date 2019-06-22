var app = {
    $wrapper : $wrapper = document.getElementById('wrapper'),
    init : init
};
function init(){
    $wrapper.innerHTML = login_form();
    document.getElementById('signin_btn')
            .addEventListener('click', e=>{
            e.preventDefault();
            alert("회원가입 버튼을 누르셨습니다!!")
            $wrapper.innerHTML = join_form();
            document.getElementById('Confirm_btn')
                    .addEventListener('click', e=>{
                    e.preventDefault();
                    alert("가입되었습니다!!")
                    join();
                
        })
    }
)}



function login_form(){
    return '<form action="/action_page.php">'
    +'  ID:<br>'
    +'  <input type="text" id="userid" name="userid">'
    +'  <br>'
    +'  Password:<br>'
    +'  <input type="text" id="password" name="password">'
    +'  <br><br>'
    +'  <input id="login-btn" type="button" value="LOGIN">'
    +'  <input id="signin_btn" type="button" value="JOIN">'
    +'  <input id="admin-btn" type="button" value="관리자">'
    +'</form> ';
 };
function join_form(){
    return '<form action="/action_page.php">'
    +'  ID:<br>'
    +'  <input type="text" id="userid" name="userid">'
    +'  <br>'
    +'  Password:<br>'
    +'  <input type="text" id="password" name="password">'
    +'  <br>'
    +'  phone:<br>'
    +'  <input type="text" id="phone" name="phone">'
    +'  <br>'
    +'  address:<br>'
    +'  <input type="text" id="address" name="address">'
    +'  <br><br>'
    +'  <input id="Confirm_btn" type="button" value="확인">'
    +'  <input id="cancel" type="button" >'
    +'</form> ';
 };

join=()=>{
    let xhr = new XMLHttpRequest();
    let data = {
        userId : document.getElementById("userid").value,
        password : document.getElementById("password").value,
        phone : document.getElementById("phone").value,
        address : document.getElementById("address").value
    }

    xhr.open('POST','users',true);
    xhr.setRequestHeader('Content-type','application/json;charset=UTF-8');


    xhr.onload=()=>{
            if(xhr.readyState === 4 && xhr.status === 200){
            alert('성공')
            // let wrapper = document.getElementById('wrapper');
            $wrapper.innerHTML = login_form();
            }else{
            alert('fail')
            }
    }
    xhr.send(JSON.stringify(data));
}