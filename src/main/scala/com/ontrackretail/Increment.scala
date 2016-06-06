package com.ontrackretail

import scala.collection.immutable.Nil

object Increment extends App {


  def inc(number: Seq[Int]): Seq[Int] = number match {
    case Nil => Nil
    case x :: xs => (x + 1) +: inc(xs)
  }

  assert(inc(Nil) == Nil, "Failed to increment empty list")
  assert(inc(Seq(0)) == Seq(1), "Failed to increment one digit")
  assert(inc(Seq(8)) == Seq(9), "Failed to increment one digit")
}
