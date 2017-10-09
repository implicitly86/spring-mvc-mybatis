
Simple spring-webmvc, mybatis application
------------------------------------------
Create database:
```postgresql
CREATE DATABASE "spring-webmvc-mybatis"
```
```postgresql
CREATE TABLE public.items
(
  id bigint NOT NULL,
  name character varying(255),
  ref_category bigint NOT NULL,
  CONSTRAINT items_pkey PRIMARY KEY (id)
)
```
```postgresql
CREATE TABLE public.category
(
  id bigint,
  name character varying(255) NOT NULL,
  CONSTRAINT category_pkey PRIMARY KEY (id)
)
```

Start application:
```bash
gradle appStart
```

1. Add new item:
```bash
curl -X POST -d '{"id":1,"name":"Apple","category":{"id":1,"name":"Phones"}}' -H "Content-Type: application/json" http://localhost:8080/spring-mvc-mybatis/item
```
2. Get item with id:
```bash
curl http://localhost:8080/spring-mvc-mybatis/item/1
```
3. Update item:
```bash
curl -X PUT -d '{"id":1,"name":"Samsung","category":{"id":1,"name":"Phones"}}' -H "Content-Type: application/json" http://localhost:8080/spring-mvc-mybatis/item
```
4. Delete item:
```bash
curl -X DELETE http://localhost:8080/spring-mvc-mybatis/item/1
```
