$(document).ready(function() {
   //document.getElementById('account_number_transfer').value = localStorage.DestinationAccount;
});

async function registerAccount(){
      let data = {};
      data.number_account = document.getElementById('txtNumber').value;
      data.balance_account = document.getElementById('txtbalance').value;
      data.id_typeaccount = 1;
      data.id_statusaccount = 1 ;

        const request = await fetch('api/account', {
            method: 'POST',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
      });
}


async function registerTransaction(){
      let data = {};
      data.number_account = document.getElementById('txtNumber').value;
      data.balance_account = document.getElementById('txtbalance').value;
      data.id_typeaccount = 1;
      data.id_statusaccount = 1 ;

        const request = await fetch('api/account', {
            method: 'POST',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
      });
}