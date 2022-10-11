$(document).ready(function() {
   // on ready
});


async function EnterNumber() {

  let datas = {};
  datas.number_account = document.getElementById('account_number').value;
  let operation = "Send";

  const request = await fetch('api/accounts_number_balance/' + operation, {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datas)
  });

  const answer = await request.text();
  if (answer != 'FAIL') {
   localStorage.SendAccount = datas.number_account;
   alert(localStorage.SendAccount)
   alert("Success")
   window.location.href = 'main.html'
  } else {
    alert("La cuenta no existe");
  }

}