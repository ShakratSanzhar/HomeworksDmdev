CREATE
DATABASE instagram_analog;

CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    email    VARCHAR(128) UNIQUE NOT NULL,
    password VARCHAR(128) UNIQUE NOT NULL,
    role     VARCHAR(128)        NOT NULL
);

CREATE TABLE user_details
(
    id                SERIAL PRIMARY KEY,
    user_id           INT REFERENCES users (id),
    name              VARCHAR(128)        NOT NULL,
    surname           VARCHAR(128)        NOT NULL,
    birthday          DATE                NOT NULL,
    phone             VARCHAR(128) UNIQUE NOT NULL,
    registration_date DATE                NOT NULL
);

CREATE TABLE post
(
    id          SERIAL PRIMARY KEY,
    image       VARCHAR(128) NOT NULL,
    created_at  DATE         NOT NULL,
    description TEXT,
    user_id     INT REFERENCES users (id)
);

CREATE TABLE tag
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(128) UNIQUE NOT NULL
);

CREATE TABLE post_tag
(
    post_id INT REFERENCES post (id),
    tag_id  INT REFERENCES tag (id)
);

CREATE TABLE comment
(
    id         SERIAL PRIMARY KEY,
    content    TEXT NOT NULL,
    created_at DATE NOT NULL,
    post_id    INT REFERENCES post (id),
    user_id    INT REFERENCES users (id)
);

CREATE TABLE likes
(
    id      SERIAL PRIMARY KEY,
    post_id INT REFERENCES post (id),
    user_id INT REFERENCES users (id)
);

CREATE TABLE chat
(
    id      SERIAL PRIMARY KEY,
    user_id INT REFERENCES users (id)
);

CREATE TABLE message
(
    id               SERIAL PRIMARY KEY,
    receiver_user_id INT REFERENCES users (id),
    sender_user_id   INT REFERENCES users (id),
    content          TEXT NOT NULL,
    created_at       DATE NOT NULL,
    chat_id          INT REFERENCES chat (id)
);

CREATE TABLE complaint
(
    id   SERIAL PRIMARY KEY,
    type VARCHAR(128) UNIQUE NOT NULL
);

CREATE TABLE post_complaint
(
    post_id      INT REFERENCES post (id),
    complaint_id INT REFERENCES complaint (id)
);

CREATE TABLE subscription
(
    id                  SERIAL PRIMARY KEY,
    user_id             INT REFERENCES users (id),
    subscribing_user_id INT REFERENCES users (id)
);