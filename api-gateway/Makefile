build:
	docker build -t api-gateway .

run:
	docker container run -d -p 8080:8080 --name api-gateway

tag:
	docker tag scheduling-service laub3/api-gateway:1.0

push:
	docker push laub3/api-gateway:1.0

run_dev:
	docker compose up

build_jar:
	mvn install