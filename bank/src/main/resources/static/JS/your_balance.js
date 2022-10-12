$(document).ready(function() {
  LoadBalance();
});

async function LoadBalance(){
      let data = {};
      data.number_account = localStorage.SendAccount;
      let number = localStorage.SendAccount;
      const request = await fetch('api/accountAskBalance/' + number , {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
         body: JSON.stringify(data)
       });
      const balance = await request.json();
      console.log(balance);
      document.getElementById('yourBalance').value = balance;

}