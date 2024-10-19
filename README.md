Energy Monitoring Application

# PostgreSQL

## DDL and DCL Commands





```sql
CREATE USER new_user WITH PASSWORD 'password';
```

```sql
ALTER USER new_user CREATEDB;
```

```sql
CREATE DATABASE database_name;
```


```sql
GRANT CONNECT ON DATABASE database_name TO new_user;

```


```sql
GRANT ALL PRIVILEGES ON TABLE table_name TO new_user;
```








