package com.ontrackretail

object Options extends App {

  val myStringOption = Some("test")

  myStringOption map (s => println(s))

  for (s <- myStringOption) yield println(s)

  myStringOption foreach (s => println(s))

  if (myStringOption.isDefined) println(myStringOption.get)

}
