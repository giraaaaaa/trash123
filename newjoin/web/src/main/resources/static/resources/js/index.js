var app = {
    $wrapper : $wrapper = document.querySelector('#wrapper'),
    init : init
}


function init() {
    alert("test");
    $wrapper.innerHTML = login_form();

    document.querySelector('#join-btn')
    .addEventListener('click',()=>{
        $wrapper.innerHTML = user.join_form();
        document.getElementById('confirm-btn')
                .addEventListener('click', e=>{
                    e.preventDefault();
                    user.join();
        });
    });

    $wrapper.innerHTML = login_from();
    document.getElementById('join-btn')
            .addEventListener('click', e=>{
                e.preventDefault();
                $wrapper.innerHTML = join_form();
                document.getElementById('confirm-btn')
                        .addEventListener('click', e=>{
                            e.preventDefault();
                            join();
                        })
            })
}
function login_from(){
    return '<form action="/action_page.php">'
    +'  ID:<br>'
    +'  <input type="text" id="userid" name="userid">'
    +'  <br>'
    +'  Password:<br>'
    +'  <input type="text" id="password" name="password">'
    +'  <br><br>'
    +'  <input id="login-btn" type="button" value="LOGIN">'
    +'  <input id="join-btn" type="button" value="JOIN">'
    +'</form> ';

}

function join(){
    let xhr = new XMLHttpRequest();
    let data = {
        userid : document.getElementById("userid").value,
        password : document.getElementById("password").value,
        phone : document.getElementById("phone").value,
        address : document.getElementById("address").value
    }

    xhr.open('POST','users',true);
    xhr.setRequestHeader('Content-type','application/json;charset=UTF-8');
    xhr.onload=()=>{
        if(xhr.readyState === 4 && xhr.status === 200){
            let d = JSON.parse(xhr.responseText);
            alert("테스트");
            alert(d.userid)
        }else{
            alert("실패");
        }
    
    }
   
    xhr.send(JSON.stringify(data));
}

function join_form(){
    return '<form action="/action_page.php">'
    +'  ID:<br>'
    +'  <input type="text" id="userid" name="userid">'
    +'  <br>'
    +'  Password:<br>'
    +'  <input type="text" id="password" name="password">'
    +'  <br>'
    +'  Phone:<br>'
    +'  <input type="text" id="phone" name="phone">'
    +'  <br>'
    +'  Address:<br>'
    +'  <input type="text" id="address" name="address">'
    +'  <br>'
    +'  <br><br>'
    +'  <input id="confirm-btn" type="button" value="CONFIRM">'
    +'</form> ';
}

function mypage (x){
    $wrapper.innerHTML = user.mypage_form(x);
    alert('마이페이지로 넘어온 객체명 :' + x.userid)
    document.querySelector('#update-btn')
    .addEventListener('click',e=>{
    user.update(x);
    e.preventDefault();

    })
    document.querySelector('#remove-btn')
    .addEventListener('click',e=>{
     $wrapper.innerHTML = user.remove(x);
     e.preventDefault();
    })   
    
    return '<h1>마이페이지</h1> ';
};

function mypage_form(x){
    let user = x;
    return '<spen>' + user.userid + '마이페이지' + '<br />'
    +'<spen> ID : ' + user.userid + '</spen><br/>'
    +'<spen> PW : ' + user.password + '</spen><br/>'
    +'<spen> phone : ' + user.phone + '</spen><br/>'
    +'<spen> address : ' + user.address + '</spen><br/>'
    +'<input id="update-btn" type="button" value="수  정">'
    +'<input id="remove-btn" type="button" value="탈  퇴">'
}
function update_form(x){
    let update = x;
    let template = '<form>'
    +'<spen> ID : ' + update.userid + '</spen><br/>'
    +'P W<br>'
    +'    <input type="password" id="password" name="password" value="'+update.password+'"><br>'
    +'phone<br>'
    +'    <input type="text"  id="phone" name="phone" value="'+update.phone+'"><br>'
    +'address<br>'
    +'    <input type="text"  id="address" name="address" value="'+update.address+'"><br>'
    +'    <input id="complete-btn" type="button" value="완료" >'
    +'    <input id="cancel-btn" type="reset" value="취소">'
    +'</form>'
    return template;
 };
 function update(x){
    let wrapper = document.querySelector('#wrapper');
    wrapper.innerHTML = user.update_form(x);
   
    alert(x.userid);
    
    document.querySelector('#complete-btn')
            .addEventListener('click',e=>{
            e.preventDefault();
            let update_data ={
                userid : x.userid,
                password : document.getElementById("password").value,
                phone : document.getElementById("phone").value,
                address : document.getElementById("address").value,
            }
            alert(x.userid);
            var xhr = new XMLHttpRequest();
            xhr.open('PUT', 'users/'+x.userid, true);
            xhr.setRequestHeader('Content-type','application/json;charset=UTF-8');
            xhr.onload=()=>{ 
                if(xhr.readyState=== 4 && xhr.status === 200){
                    let d = JSON.parse(xhr.responseText);
                    alert('수정완료' +d.userid)
                    alert(d);
                    if(d){
                        alert('수정완료' + d.result);
                        $wrapper.innerHTML = login_form();
                    }else{
                        alert("수정실패")
                        $wrapper.innerHTML = login_form();
                    }
                }else{
                    alert("수정실패2")

                }
            };
            xhr.send(JSON.stringify(update_data));

    })
    document.querySelector('#cancel-btn')
            .addEventListener('click',e=>{
            user.mypage(x);
            e.preventDefault();
    })
        
    }
