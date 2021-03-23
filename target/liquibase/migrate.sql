-- *********************************************************************
-- Update Database Script
-- *********************************************************************
-- Change Log: src/main/resources/db/master.xml
-- Ran at: 23.03.21 17:49
-- Against: liquibase_example_user@jdbc:postgresql://localhost:5432/liquibase_example
-- Liquibase version: 3.8.9
-- *********************************************************************

-- Create Database Lock Table
CREATE TABLE databasechangeloglock (ID INTEGER NOT NULL, LOCKED BOOLEAN NOT NULL, LOCKGRANTED TIMESTAMP WITHOUT TIME ZONE, LOCKEDBY VARCHAR(255), CONSTRAINT DATABASECHANGELOGLOCK_PKEY PRIMARY KEY (ID));

-- Initialize Database Lock Table
DELETE FROM databasechangeloglock;

INSERT INTO databasechangeloglock (ID, LOCKED) VALUES (1, FALSE);

-- Lock Database
UPDATE databasechangeloglock SET LOCKED = TRUE, LOCKEDBY = '172.18.8.114 (172.18.8.114)', LOCKGRANTED = '2021-03-23 17:49:15.843' WHERE ID = 1 AND LOCKED = FALSE;

-- Create Database Change Log Table
CREATE TABLE databasechangelog (ID VARCHAR(255) NOT NULL, AUTHOR VARCHAR(255) NOT NULL, FILENAME VARCHAR(255) NOT NULL, DATEEXECUTED TIMESTAMP WITHOUT TIME ZONE NOT NULL, ORDEREXECUTED INTEGER NOT NULL, EXECTYPE VARCHAR(10) NOT NULL, MD5SUM VARCHAR(35), DESCRIPTION VARCHAR(255), COMMENTS VARCHAR(255), TAG VARCHAR(255), LIQUIBASE VARCHAR(20), CONTEXTS VARCHAR(255), LABELS VARCHAR(255), DEPLOYMENT_ID VARCHAR(10));

-- Changeset src/main/resources/db/changelog/V1.0.1.xml::2020-05-25 11:11:00::kbulychev
create sequence if not exists account_entity_liquibase_seq start 1;

CREATE TABLE if not exists account_entity_liquibase
(
    user_id  bigint       not null default nextval('account_entity_liquibase_seq' :: regclass),
    username VARCHAR(50)  NOT NULL,
    password VARCHAR(50)  NOT NULL,
    country  VARCHAR(355) NOT NULL
);

alter table account_entity_liquibase
    add constraint account_entity_liquibase_pk primary key (user_id);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('2020-05-25 11:11:00', 'kbulychev', 'src/main/resources/db/changelog/V1.0.1.xml', NOW(), 1, '8:6427df294cf536489a5e46f669bc6639', 'sqlFile', '', 'EXECUTED', NULL, NULL, '3.8.9', '6510957096');

-- Release Database Lock
UPDATE databasechangeloglock SET LOCKED = FALSE, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

