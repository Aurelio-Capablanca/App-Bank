$(document).ready(function() {

});

var strToken = localStorage.token;
var strId = strToken[strToken.length-1];
var intId = parseInt(strId);

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
               const request = await fetch('/clients/' + id, {
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