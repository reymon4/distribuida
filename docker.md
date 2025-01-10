```
docker run --name dbserver1 -p 54321:5432 -e POSTGRES_PASSWORD=root -e POSTGRES_DB=distribuida -d postgres:17.2-alpine3.21
```

```
docker pull consul:1.15.4
```

```
docker pull traefik:v3.3.1
```