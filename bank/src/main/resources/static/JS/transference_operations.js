$(document).ready(function() {
   //document.getElementById('account_number_transfer').value = localStorage.DestinationAccount;
});


async function TransactionsOperations(){
 CreateTransaction();
 UpdateDestAccount();
 UpdateSentAccount();
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


async function UpdateSentAccount(){
      let data = {};
      data.number_account = localStorage.DestinationAccount;
      let number = localStorage.SendAccount.DestinationAccount;

       const request = await fetch('api/accountUpDest/'+ number, {
            method: 'PUT',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
      });
}

async function UpdateDestAccount(){
      let data = {};
      data.number_account = localStorage.SendAccount;
      let number = localStorage.SendAccount;

        const request = await fetch('api/accountUpDest/'+ number, {
            method: 'PUT',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
      });
}