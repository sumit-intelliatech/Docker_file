
#how to Run the Docker FILE
# 1)To Get MySQL
# docker pull mysql
# 2) create a image of Java Application
# docker build -t IMAGENAME
# 3)create NetWork
# ---->create network bootApp
# ---->docker network create bootApp
#SPRING BOOT
# ---->docker run -it --name test -p 8080:8080 --network=bootApp -e MYSQL_HOST=mysqldb -e MYSQL_PORT=3306 dockertest
#MYSQL
# --->docker run -d --name mysqldb -p 3307:3306 --network=bootApp -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=dockerdb mysql
#How to run the docker compose file
# ------>docker compose up -d

