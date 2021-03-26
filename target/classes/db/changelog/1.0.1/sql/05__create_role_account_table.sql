Create table if not exists role_accounts(
role_id int not null,
account_id int not null,
  FOREIGN KEY (role_id) REFERENCES users(id) ON UPDATE CASCADE,
  FOREIGN KEY (account_id) REFERENCES roles(id) ON UPDATE CASCADE
)

