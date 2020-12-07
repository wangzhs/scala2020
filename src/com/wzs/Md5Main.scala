package com.wzs

import java.security.MessageDigest

/**
 * @Author wangzhs
 * @create 2020/12/7 15:28
 */
object Md5Main extends App {

  def hashMD5(content: String): String = {
    val md5 = MessageDigest.getInstance("MD5")
    val encoded = md5.digest((content).getBytes)
    encoded.map("%02x".format(_)).mkString
  }

  //  http://localhost:8888/m.api?
  //    _aid=0
  //    &_mt=cruze.getDeptListV2
  //    &_sm=md5
  //    &hospitalId=6841
  //    &_sig=c8fe3a9e11c8f2156c7252548d536d33
  //  02436a25669799a22352de7fb88ae91f
  //  "_aid=0_mt=cruze.getDeptListV2_sm=md5hospitalId=6841"

  println(hashMD5(Map(
    "_aid" -> "0",
    "_mt" -> "cruze.getDeptListV2",
    "_sm" -> "md5",
    "hospitalId" -> "6841"
  ).mkString("", "", "")))
}
