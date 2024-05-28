build:
	docker build -t service-discovery .

run:
	docker container run -d -p 8080:8080 --name service-discovery

tag:
	docker tag service-discovery laub3/service-discovery:1.0

push:
	docker push laub3/service-discovery:1.0

run_dev:
	docker compose up

build_jar:
	mvn install