// Call the dataTables jQuery plugin
$(document).ready(function() {
    //on ready
});

async function addUsers(){
      let datee = {};
      datee.name_client = document.getElementById('txtName').value;
      datee.surname_client = document.getElementById('txtLastName').value;
      datee.phone_client = document.getElementById('txtTel').value;
      datee.email_client = document.getElementById('txtEmail').value;
      datee.dni_client = document.getElementById('txtDNI').value;
      datee.user_client = document.getElementById('txtUsername').value;
      datee.password_client = document.getElementById('txtPassword').value;
      datee.id_statusclient = 1;




      let repetirContraseña = document.getElementById('txtPassword2').value;
      if(repetirContraseña != datee.password_client){
            alert('La contraseña es diferente');
            return;
      }

        //peticion al servidor
      const request = await fetch('api/clients', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(datee)

      });
      alert("El usuario se ha registrado con exito");
      //window.location.href =  'login.html';

}