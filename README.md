Parte do backend+banco de dados. Utilizo mariadb para depositar as informações enviadas direto do front-end. Através da requisição de certos end-points,
o front envia informações em forma de json que são lidas e armazenadas pelo spring boot no databaseSQL (mariadb).

## Configuracao MariaDB no startup

O projeto usa variaveis de ambiente para login do banco:

- `DB_HOST` (default: `localhost`)
- `DB_PORT` (default: `3306`)
- `DB_NAME` (default: `estoque`)
- `DB_USER` (default: `monty`)
- `DB_PASS` (default: `12`)

Exemplo para subir o backend:

```bash
./gradlew bootRun
```


