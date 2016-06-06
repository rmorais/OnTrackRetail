package com.ontrackretail

import scala.collection.immutable.Nil

object Increment extends App {


  def inc(number: Seq[Int]) = Nil

  assert(inc(Nil)==Nil, "Failed to increment empty list")
}
