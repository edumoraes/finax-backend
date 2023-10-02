CREATE TABLE user
(
    id         VARCHAR(36) NOT NULL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    role       ENUM ('OWNER', 'USER', 'ADMIN', 'GUEST'),
    email      VARCHAR(255) UNIQUE,
    password   VARCHAR(255),
    PRIMARY KEY (id)
);
CREATE TABLE user_account_organization
(
    user_id                 VARCHAR(36) NOT NULL,
    account_organization_id INT         NOT NULL,
    PRIMARY KEY (user_id, account_organization_id),
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (account_organization_id) REFERENCES account_organization (id)
);
CREATE TABLE account_organization
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(255),
    address_id INT,
    document   VARCHAR(255) UNIQUE,
    owner_id   VARCHAR(36) NOT NULL,
    type       ENUM ('COMPANY', 'NONPROFIT', 'GOVERNMENT', 'EDUCATIONAL', 'RELIGIOUS', 'INDIVIDUAL', 'OTHER', 'UNKNOWN'),
    FOREIGN KEY (address_id) REFERENCES postal_address (id),
    FOREIGN KEY (owner_id) REFERENCES user (id),
    CHECK (type IN ('COMPANY', 'NONPROFIT', 'GOVERNMENT', 'EDUCATIONAL', 'RELIGIOUS', 'INDIVIDUAL', 'OTHER', 'UNKNOWN'))
);
CREATE TABLE postal_address
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    street       VARCHAR(255),
    number       VARCHAR(10),
    complement   VARCHAR(255),
    neighborhood VARCHAR(255),
    city         VARCHAR(255),
    state        VARCHAR(255),
    country      VARCHAR(255),
    zipCode      VARCHAR(20)
);