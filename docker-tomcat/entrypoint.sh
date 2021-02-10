#!/bin/bash 

CATALINA_SCRIPT="/tomcat/bin/catalina.sh" 


start_tomcat() {
		$CATALINA_SCRIPT run
} 

stop_tomcat() {
		echo "Try to stop tomcat ..." | tee /tmp/shutdown.log
		$CATALINA_SCRIPT stop
}

trap stop_tomcat SIGTERM

start_tomcat
