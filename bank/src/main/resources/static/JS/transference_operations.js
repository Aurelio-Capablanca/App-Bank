$(document).ready(function() {
   //document.getElementById('account_number_transfer').value = localStorage.DestinationAccount;
});


async function TransactionsOperations(){
 CreateTransaction();
}

async function CreateTransaction(){
      let data = {};
      data.balance_transaction = document.getElementById('account_amount').value;
      data.id_typetransaction = 3;
      data.id_statustransaction = 1;

        const request = await fetch('api/transactions', {
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