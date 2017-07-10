package com.iqmsoft.osgi.scala

import org.apache.camel.scala.dsl.builder.RouteBuilder
import org.apache.camel.Exchange


class MyRouteBuilder extends RouteBuilder {

  
  val myProcessorMethod = (exchange: Exchange) => {
    exchange.getIn.setBody("block test")
  }

 
  "timer://foo?period=5s" ==> {
    process(myProcessorMethod)
    log("block")
    to("mock:result")
  }
}