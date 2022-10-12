$(document).ready(function() {
   document.getElementById('id_user').value =  localStorage.userName;
   document.getElementById('lblId').value =  strId;
    response1(intId);
});

var strToken = localStorage.token;
var strId = strToken[strToken.length-1];
var intId = parseInt(strId);

async function response1(id){


        //peticion al servidor
      const request = await fetch('/cliii/'+ id, {
        method: 'GET',
        headers: getHeaders()
      });

      const clients = await request.json();

      console.log(clients);
      document.getElementById('name_user').value = clients.name_client;
      document.getElementById('surname_user').value = clients.surname_client;
      document.getElementById('txtDNI').value = clients.dni_client;
      document.getElementById('email_user').value = clients.email_client;
      document.getElementById('txtTel').value = clients.phone_client;
      document.getElementById('client_user').value = clients.user_client;

}


function execute(){
    edit(intId);
}

async function edit(id){
         let datee = {};
              datee.name_client = document.getElementById('name_user').value;
              datee.surname_client = document.getElementById('surname_user').value;
              datee.phone_client = document.getElementById('txtTel').value;
              datee.email_client = document.getElementById('email_user').value;
              datee.dni_client = document.getElementById('txtDNI').value;
              datee.user_client = document.getElementById('client_user').value;
              datee.id_statusclient = 1;



                //peticion al servidor
               const request = await fetch('/cliii/' + id, {
                      method: 'PUT',
                      headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                      },
                      body: JSON.stringify(datee)

                    });
              alert("Cambios guardados con exito");
}


function getHeaders(){
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    }
}