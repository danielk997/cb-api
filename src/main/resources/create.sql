CREATE TABLE Persons
(
    id    numeric not null,
    email varchar(255) unique
)

CREATE TABLE Permissions
(
    name varchar(100) unique
)

CREATE TABLE PersonsPermissionLink
(
    personEmail    varchar(255),
    permissionName varchar(100),
    FOREIGN KEY (personEmail) references Persons (email),
    FOREIGN KEY (permissionName) references Permissions (name)
)

INSERT INTO Persons (id, email)
VALUES (1, N'dankociolek97@gmail.com');

