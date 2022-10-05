$(document).ready(function() {

});


idUs = document.getElementById('txtId').value;

function mostrarLink(){

       var idUs = document.getElementById('txtId').value;
       linkEditarUsuarios(idUs)
}


async function linkEditarUsuarios(id){
        //peticion al servidor


let datos = {};
      datos.nombre = document.getElementById('txtName').value;
      datos.apellido = document.getElementById('txtLastName').value;
      datos.email = document.getElementById('txtEmail').value;
      datos.telefono = document.getElementById('txtPhone').value;


      const request = await fetch('api/usuarios/' + id, {
        method: 'PUT',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)

         });

}
