CREATE TABLE "users" (
                         "id" serial PRIMARY KEY,
                         "name" varchar(255),
                         "role_id" integer
);

CREATE TABLE "roles" (
                         "id" serial PRIMARY KEY,
                         "role" varchar(255),
                         "user_id" integer
);

CREATE TABLE "rules" (
                         "id" serial PRIMARY KEY,
                         "rule" varchar(255)
);

CREATE TABLE "items" (
                         "id" serial PRIMARY KEY,
                         "item" varchar(255),
                         "user_id" integer,
                         "actor_id" integer,
                         "category_id" integer,
                         "state_id" integer
);

CREATE TABLE "comments" (
                            "id" serial PRIMARY KEY,
                            "comment" text,
                            "item_id" integer
);

CREATE TABLE "attachs" (
                           "id" serial PRIMARY KEY,
                           "attach" text,
                           "item_id" integer
);

CREATE TABLE "categories" (
                              "id" serial PRIMARY KEY,
                              "category" varchar(255)
);

CREATE TABLE "states" (
                          "id" serial PRIMARY KEY,
                          "state" varchar(255)
);

CREATE TABLE "roles_rules" (
                               "id" serial PRIMARY KEY,
                               "role_id" integer,
                               "rule_id" integer
);

ALTER TABLE "users" ADD FOREIGN KEY ("role_id") REFERENCES "roles" ("id");

ALTER TABLE "roles_rules" ADD FOREIGN KEY ("role_id") REFERENCES "roles" ("id");

ALTER TABLE "roles_rules" ADD FOREIGN KEY ("rule_id") REFERENCES "rules" ("id");

ALTER TABLE "items" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "comments" ADD FOREIGN KEY ("item_id") REFERENCES "items" ("id");

ALTER TABLE "attachs" ADD FOREIGN KEY ("item_id") REFERENCES "items" ("id");

ALTER TABLE "items" ADD FOREIGN KEY ("category_id") REFERENCES "categories" ("id");

ALTER TABLE "items" ADD FOREIGN KEY ("state_id") REFERENCES "states" ("id");
