CREATE TABLE parties_friends (
id SERIAL PRIMARY KEY,
party_id INTEGER REFERENCES parties(id),
friend_id INTEGER REFERENCES friends(id)
);
