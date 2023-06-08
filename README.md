# server-boardgamer

## ROUTING AND ENDPOINTS
## API Endpoints (backend routes)
CRUD OF USER ROUTES: 
| HTTP Method | URL                                   | Request Body                 | Success status | Error Status | Description                                                  |
| ----------- | ---------------------------           | ---------------------------- | -------------- | ------------ | ------------------------------------------------------------ |
| GET         | `/api/user/{id}    `                |                | 200            | 404          | Search specific users information           |
| PUT         | `/api/user/{id}/edit`             |  {username, email, selfDescription, profilePic, role}     |             | 400          | Updates user's information |
| POST         | `/api/user/add-user`             |      | 200            | 400          | Creates user | 
| POST         | `/api/user//add-game/{userId}/{gameId}`             |       |             | 400          | Adds specific game to a collection of user|
| POST         | `/api/user/{id}/edit`             |  {username, email, selfDescription, profilePic, role}     |             | 400          | Return the logged user information |

| DELETE         | `/api/user/{id}/delete`                 |          | 200            | 401          | Return one user information    |


#### Testing routes in postman
![Postman](Postman.JPG)

#### Class Diagram downloaded from MySQL Workbench
![classDiagram](classDiagram.png)

