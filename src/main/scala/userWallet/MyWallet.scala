package userWallet

import org.springframework.boot.SpringApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.GenericXmlApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.ApplicationContext;


import scala.collection.JavaConversions._



object MyWallet {

 
	def main(args: Array[String]) {
	 
    
    
    
	   SpringApplication.run(classOf[WalletConfig]);
	}
}