insert into account values(0001, 'Ben', 'SAVINGS', sysdate(), 'AUD', '55.5');
insert into account values(0002, 'Mike', 'CURRENT', sysdate(), 'AUD', '3000');
insert into account values(0003, 'Matt', 'SAVINGS', sysdate(), 'SGD', '1000');


-- Transactions for 10001
insert into transaction values(1001, 10.5, 10, 'DEBIT', 'First transaction for Ben', sysdate(), 0001);
insert into transaction values(1002, 9.5, 10, 'CREDIT', 'Second transaction  for Ben', sysdate(), 0001);
insert into transaction values(1003, 4, 1, 'DEBIT', 'Third transaction for Ben', sysdate(), 0001);
