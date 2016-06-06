package com.ontrackretail

import scala.collection.immutable.Nil

object Increment extends App {

  def inc(number: Seq[Int]): Seq[Int] = {

    def reverseInc(number: Seq[Int]): Seq[Int] = number match {
      case Nil => Nil
      case x :: Nil if x == 9 => Seq(0,1)
      case x :: xs if x == 9 => 0 +: reverseInc(xs)
      case x :: xs => x + 1 :: xs
    }

    reverseInc(number.reverse).reverse
  }

  assert(inc(Nil) == Nil, s"inc(Nil) ${inc(Nil)}")
  assert(inc(Seq(0)) == Seq(1), s"inc(Seq(0)): ${inc(Seq(0))}")
  assert(inc(Seq(1,2)) == Seq(1,3), s"inc(Seq(1,2)): ${inc(Seq(1,2))}")
  assert(inc(Seq(1,9)) == Seq(2,0), s"inc(Seq(1,9)): ${inc(Seq(1,9))}")
  assert(inc(Seq(1,2,3)) == Seq(1,2,4), s"Seq(1,2,3)): ${Seq(1,2,3)}")
  assert(inc(Seq(9)) == Seq(1,0), s"inc(Seq(9)): ${inc(Seq(9))}")
  assert(inc(Seq(9,9)) == Seq(1,0,0), s"inc(Seq(9,9)): ${inc(Seq(9,9))}")
  assert(inc(Seq(1,9,9)) == Seq(2,0,0), s"inc(Seq(1,9,9)): ${inc(Seq(1,9,9))}")
  assert(inc(Seq(9,9,9)) == Seq(1,0,0,0), s"inc(Seq(9,9,9)): ${inc(Seq(9,9,9))}")
}
