$(document).ready(function() {
  LoadBalance();
});

async function LoadBalance(){
      let number = localStorage.SendAccount;
      const request = await fetch('api/accountAskBalance/' + number , {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }
         });
      const balance = await request.json();
      console.log(balance);
      document.getElementById('yourBalance').value = balance.balance_account;
}