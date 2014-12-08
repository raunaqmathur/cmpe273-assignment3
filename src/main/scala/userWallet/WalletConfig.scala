package userWallet

import com.justinsb.etcd.{EtcdResult,EtcdClient}
import org.springframework.context.annotation.{ Conditional, ConditionContext, Configuration }
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.{ RequestMapping, RequestMethod, RequestParam, RequestBody, RequestHeader }
import org.springframework.web.bind.annotation.{ ResponseBody, ResponseStatus, PathVariable }
import org.springframework.web.bind.annotation.RestController
import collection.JavaConverters._

import org.springframework.http.ResponseEntity
import java.util.Date
import org.springframework.http._
import scala.util.control.Exception._
import java.lang._
import java.util.Iterator
import java.util.ArrayList
import java.util.Arrays
import java.util.List

import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired;
import java.net.URI

@Configuration
@EnableAutoConfiguration
@ComponentScan
@RestController
class WalletConfig {
  
   val client = new EtcdClient(URI.create("http://54.183.248.44:4001/"))
  val key = "/009527427/counter"
  var value : Int = 0
  var result: EtcdResult = this.client.set(key, value.toString)

    @RequestMapping(value = Array("/api/v1/counter"),method=Array(RequestMethod.GET))
  @ResponseBody
  def counterConfig(): String = {
		
		    result = this.client.get(key)
		    value = result.node.value.toInt + 1
		    result = this.client.set(key, value.toString)
		    result = this.client.get(key)
		    result.node.value

		    
  }


  @RequestMapping(value = Array("/health"),method=Array(RequestMethod.GET))
  @ResponseBody
  def health(): String = {
		
		   return "true"
		    
  }


}


