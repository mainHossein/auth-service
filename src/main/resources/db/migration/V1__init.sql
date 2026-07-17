DROP TABLE IF EXISTS "user_credential";
CREATE TABLE "user_credential"
(
    "id"         UUID NOT NULL,
    "created_at" TIMESTAMP,
    "updated_at" TIMESTAMP,
    "version" INTEGER,
    "username"   VARCHAR,
    "password"   VARCHAR,
    CONSTRAINT user_credential_pk PRIMARY KEY("id"),
    UNIQUE("username")
);

DROP TABLE IF EXISTS "user_roles";
CREATE TABLE "user_roles"
(
    "id"         UUID NOT NULL,
    "created_at" TIMESTAMP,
    "updated_at" TIMESTAMP,
    "version" INTEGER,
    "fk_user_id" UUID NOT NULL,
    "role" VARCHAR NOT NULL,
    CONSTRAINT user_roles_pk PRIMARY KEY ("id"),
    CONSTRAINT user_roles_user_id FOREIGN KEY ("fk_user_id") REFERENCES "user_credential" ("id"),
    UNIQUE ("fk_user_id", "role")
);