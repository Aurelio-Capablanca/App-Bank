$(document).ready(function() {
   //document.getElementById('account_number_transfer').value = localStorage.DestinationAccount;
});


async function TransactionsOperations(){
 CreateTransaction();
 Deposit();
}


async function CreateTransaction(){
      let data = {};
      data.balance_transaction = document.getElementById('account_amountD').value;
      data.id_typetransaction = 1;
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

async function Deposit(){
      let data1 = {};
      data1.number_account = localStorage.SendAccount;
      let number = localStorage.SendAccount;

        const request = await fetch('api/accountDeposits/'+ number, {
            method: 'PUT',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(data1)
      });
      const answer = await request.text();
        if (answer != 'FAIL') {
         alert("SUCCESS")
         window.location.href = 'main.html'
        } else {
          alert("FAIL");
        }
}