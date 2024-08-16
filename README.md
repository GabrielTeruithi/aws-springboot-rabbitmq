# Objective

  This project has as main objective to introduce and develop the concepts of messaging with rabbitmq and microservices by simulating a small loan request.
  

## Technologies Used

    Java 17
    RabbitMQ
    Spring 6
    AWS SMS
    
## Main Features

  It's compoused by three microsservices:
   - analise-credito:
      - Responsible for analize, aprove or decline the loan request based on the user profile.
   - notificacao:
      - Responsible for send SMS messages to the users for each step of the proccess, and if the loan was approved or declined.
   - proposta-app:
     - Responsible for received the loan request and communicate with the others microservices

## How To Use

    ### Probably some docker version will be available later
