package com.wzs

import scala.util.matching.Regex

/**
 * @Author wangzhs
 * @create 2020/12/7 11:42
 *         正则表达式模式
 */
object RegexMain extends App {
  private val regex: Regex = "[0-9]".r

  // TODO: Some(_)不理解
  regex.findFirstMatchIn("asdasdasdsadas") match {
    case Some(_) => println("success")
    case _ => println("error")
  }

  val keyValPattern: Regex = "([0-9a-zA-Z-#() ]+): ([0-9a-zA-Z-#() ]+)".r

  val input: String =
    """background-color: #A03300;
      |background-image: url(img/header100.png);
      |background-position: top center;
      |background-repeat: repeat-x;
      |background-size: 2160px 108px;
      |margin: 0;
      |height: 108px;
      |width: 100%;""".stripMargin

  for (key <- keyValPattern.findAllMatchIn(input)) {
    println(s"${key.group(1)}:${key.group(2)}")
  }

}
