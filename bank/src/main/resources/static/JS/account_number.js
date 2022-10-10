$(document).ready(function() {
   // on ready
});


async function searchNumber() {
  let data = {};
  data.number_account = document.getElementById('account_number_transfer').value;

  const request = await fetch('api/account_number', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  });

  const answer = await request.text();
  if (answer != 'FAIL') {
  alert("Success")
    //window.location.href = 'transference_count.html'
  } else {
    alert("La cuenta no existe");
  }

}