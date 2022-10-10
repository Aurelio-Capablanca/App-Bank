$(document).ready(function() {

});

async function login(){
      let datee = {};
      datee.user_client = document.getElementById('txtUsernamee').value;
      datee.password_client = document.getElementById('txtPassword').value;
        //peticion al servidor
      const request = await fetch('api/login', {
            method: 'POST',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(datee)

      });

      const respuesta = await request.text();
            if(respuesta != "FAIL"){
                 localStorage.token = respuesta;
                 localStorage.userName = datee.user_client;
                 alert("El usuario se ha encontrado ");
                 window.location.href = "enter_account.html" ;
            } else{
                alert("Las credenciales son incorrectas. Por favor intente nuevamente.")
            }

    //  window.location.href =  'login.html';

}