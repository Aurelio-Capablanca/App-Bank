// Call the dataTables jQuery plugin
$(document).ready(function() {
   cargarUsuarios();
  $('#usuarios').DataTable();
});

async function cargarUsuarios(){
        //peticion al servidor
      const request = await fetch('api/usuarios', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }
         });

      const usuarios = await request.json();

      console.log(usuarios);


      let listadoHTML = '';
                  for(let usuario of usuarios){
                     btnEliminar = '<a href="#" onclick= "eliminarUsuario('+ usuario.id +')" class="btn btn-danger btn-circle btn-sm" style="outline-width: 0px !important; user-select: auto !important;"><i class="fas fa-trash"></i></a>';

                     let usuarioHTML = '<tr><td>' + usuario.id
                     + '</td> <td>' + usuario.nombre + ' '
                     + usuario.apellido +  '</td> <td>' + usuario.email
                     + '</td> <td>' + usuario.telefono
                     + '</td><td>'+ btnEliminar +'</td> </tr>';
                     listadoHTML += usuarioHTML;
                  }
                  document.querySelector('#usuarios tbody').outerHTML = listadoHTML;

}

async function eliminarUsuario(id){
    alert(id)
     if(!confirm('Desea eliminar este usuario?')){
        return;

      }
     //peticion al servidor
     const request = await fetch('api/usuarios/' + id , {
            method: 'DELETE',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            }
          });

     location.reload();
}
