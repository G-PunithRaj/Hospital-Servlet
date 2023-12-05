let eyeicon = document.getElementById('eyeicon')
let Password= document.getElementById('Password')

eyeicon.onclick = function(){
    if(Password.type === "Password"){
        Password.type="Password";
    }else{
        Password.type ="text";
    }
}