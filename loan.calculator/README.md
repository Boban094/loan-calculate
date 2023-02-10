Hello, this is my custom README file, added after the creation of the project

I decided to only save in one table, since POST request allows me to have a return value
For simplicity and speed I have an additional column in the table for monthly payments since the value is fixed for each month

In my logic, if the request is saved correctly, the return list will have elements where each has a value of the monthly payment and the remaining amount of the loan

Regarding the DB I decided to use postgresql since I'm mostly familiar with it

Microservices weren't needed here, but with only adding a gateway we can easily expand this app in the future

My idea is in the future to have an option for user to create an account, and when logged in to choose from which bank he wants to get his loan.
That way interest rate will be depending on the bank he chooses, he will have an option to see all of his previous calculations and can decide where to get his loan from.

This will require an auth-service, user-service and a bit of expanding of the calculation service I created