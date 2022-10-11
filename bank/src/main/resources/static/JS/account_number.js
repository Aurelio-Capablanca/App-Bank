$(document).ready(function() {
   // on ready
});


async function searchNumber() {
  let data = {};
  data.number_account = document.getElementById('account_number_transfer').value;

  const request = await fetch('api/accountdestination_number_balance', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  });

  const answer = await request.text();
  alert(answer)
  if (answer != 'FAIL') {
   localStorage.DestinationAccount = data.number_account;
   localStorage.DestinationBalance = data.balance_account;
   alert(localStorage.DestinationAccount)
   alert(localStorage.DestinationBalance)
   alert("Success")
   window.location.href = 'transference_count.html'
  } else {
    alert("La cuenta no existe");
  }

}