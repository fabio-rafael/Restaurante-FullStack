CREATE TABLE users (
    id VARCHAR(255) PRIMARY KEY UNIQUE NOT NULL,
    login VARCHAR(20) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(10) NOT NULL
)