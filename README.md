# Ticket Sale System

>
> This project will configure a domain for managing and distributing Event tickets.
> This is a great use case for different concepts.
>
> The code is kept simple enough, to understand quickly.
> And complex enough to approach a real life situation.
>
> _**Author**: Nick Bauters_  
> _**Last Major Update**: 07 oktober 2023_  
> _**version**: v0.0.1_


## Domain

## Features

## Development

### Environment Configuration

To ge the project running locally, we need to add some configuration to our environment.
A User and Password for local usage, can be created by you in the environment variables of your IDE.
Always use these environment variables in your code, to make sure you don't commit your credentials.

Live versions of this software will use the environment variables of the system it is running on.
Locally, these have to be set in your IDE as follows:
```yml
env
   .variables
      .PSGDB_DB: ticketSales
      .PSGDB_USER: user
      .PSGDB_PSW: psw
      .PSGDB_URL: jdbc:postgresql://localhost:5432/ticketSales
```

You will also need to create a ```.env``` file at the root of the project. This file will contain the following variables:

```bash
PSGDB_DB=ticketSales
PSGDB_USER=user
PSGDB_PSW=psw
PSGDB_URL=jdbc:postgresql://localhost:5432/ticketSales
```

### Database startup

This application uses a PostgresSQL database.   
The basic schema and mock data are added to the ```./data``` folder.   
The database migration files are added to the ```src/main/resources/db/migration``` folder.

You can start the database by running the following command:
```bash
docker-compose up -d
```

To stop the database and remove the volumes, run the following command:
```bash
docker-compose down -v
```

