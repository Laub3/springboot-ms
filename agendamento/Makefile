build:
	docker build -t scheduling-service .

run:
	container run -d -p 8080:8080 --name scheduling-service

tag:
	docker tag scheduling-service laub3/scheduling-service:1.0

push:
	docker push laub3/scheduling-service:1.0

run_dev:
	docker compose up

build_jar:
	mvn install