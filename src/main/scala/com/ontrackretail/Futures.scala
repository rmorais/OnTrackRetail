package com.ontrackretail

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


trait Futures {

  def f1 = Future {
    Thread.sleep(200)
    println(s"Future 1")
  }

  def f2 = Future {
    Thread.sleep(50)
    println(s"Future 2")
  }

  def f3 = Future {
    Thread.sleep(50)
    println(s"Future 3")
  }

  def f4 = Future {
    Thread.sleep(10)
    println(s"Future 4")
  }
}

object IndependentFutures extends Futures {
  def main(args: Array[String]): Unit = {
    f1;f2;f3;f4

    Thread.sleep(500)
    println("finished independent futures")
  }
}

object ChainedFutures extends Futures {
  def main(args: Array[String]): Unit = {
    for {
      r1 <- f1
      r2 <- f2
      r3 <- f3
      r4 <- f4
    } yield {
      println("finished chained futures")
    }

    Thread.sleep(500)
  }
}

object DependentFutures extends Futures {
  def main(args: Array[String]): Unit = {

    for {
      r1 <- f1
      r2 <- Future.sequence(Seq(f2,f3))
      r3 <- f4
    } yield println("finished dependent futures")

    Thread.sleep(500)

  }
}