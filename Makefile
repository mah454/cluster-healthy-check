.PHONY: build
build : 
	mvn clean compile package 
	mv target/ROOT.war docker-chc/
	docker-compose build  


clean: 
	rm -rf docker-chc/*.war 
	rm -rf target 
