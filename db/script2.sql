CREATE TABLE "film" (
                        "id" integer PRIMARY KEY,
                        "name" varchar(255),
                        "director_id" integer,
                        "premiere" date
);

CREATE TABLE "director" (
                            "id" integer PRIMARY KEY,
                            "name" varchar(255),
                            "birth_date" date
);

CREATE TABLE "actor" (
                         "id" integer PRIMARY KEY,
                         "name" varchar(255),
                         "birth_date" date
);

CREATE TABLE "film_actor" (
                              "id" integer PRIMARY KEY,
                              "film_id" integer,
                              "actor_id" integer
);

ALTER TABLE "film" ADD FOREIGN KEY ("director_id") REFERENCES "director" ("id");

ALTER TABLE "film_actor" ADD FOREIGN KEY ("film_id") REFERENCES "film" ("id");

ALTER TABLE "film_actor" ADD FOREIGN KEY ("actor_id") REFERENCES "actor" ("id");