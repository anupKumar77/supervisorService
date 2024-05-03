# supervisorService


To build run this command:
docker build -t supervisor .

To Run
docker run -p 3000:3000 supervisor

To list 
docker container ls

To Stop
docker stop <containerId>



curl --location 'http://localhost:3000/api/supervisors'


curl --location 'http://localhost:3000/api/submit' \
--header 'Content-Type: application/json' \
--data-raw '{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "phoneNumber": "123-456-7890",
  "supervisor": "Marketing - Smith, Jane"
}
'
