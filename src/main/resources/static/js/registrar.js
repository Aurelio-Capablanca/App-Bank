// Call the dataTables jQuery plugin
$(document).ready(function() {
    //on ready
});

async function registrarUsuario(){
      let datos = {};
      datos.nombre = document.getElementById('txtName').value;
      datos.apellido = document.getElementById('txtApellido').value;
      datos.email = document.getElementById('txtEmail').value;
      datos.telefono = document.getElementById('txtTelefono').value;
      datos.password = document.getElementById('txtPassword').value;

      let repetirContraseña = document.getElementById('txtRepetirContraseña').value;
      if(repetirContraseña != datos.password){
            alert('La contraseña es diferente');
            return;
      }

        //peticion al servidor
      const request = await fetch('api/usuarios', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)

      });

}
