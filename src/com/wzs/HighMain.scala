package com.wzs

/**
 * @Author wangzhs
 * @create 2020/12/2 17:47
 */
object HighMain {
  def main(args: Array[String]): Unit = {

    // 函数当做 参数 传递给方法
    var salaries = Seq(2000, 2000, 3000);
    var doubleSalary = (x: Int) => x * 2;
    println(salaries.map(doubleSalary))
    // 等同
    println(salaries.map(x => x * 2))
    // _代替参数名
    println(salaries.map(_ * 2))

    val forecast = new WeeklyWeatherForecast(Seq(1.2, 123))
    println(forecast.foreachCast)

    val getUrl = urlBuilder(domain = "test")
    println(getUrl)
    val url = getUrl("user", "a=b")
    println(url)
  }

  // 提取公共方法
  def smallPromotion(salaries: List[Double]): List[Double] =
    prom(salaries, salary => salary * 1.1)

  def greatPromotion(salaries: List[Double]): List[Double] =
    prom(salaries, salary => salary * math.log(salary))

  def hugePromotion(salaries: List[Double]): List[Double] =
    prom(salaries, salary => salary * salary)

  private def prom(salaries: List[Double], promFunction: Double => Double) = {
    salaries.map(promFunction)
  }

  case class WeeklyWeatherForecast(temps: Seq[Double]) {
    private def cover(tmp: Double) = tmp * 1.8 + 32

    def foreachCast: Seq[Double] = temps.map(cover)
  }

  //返回一个函数的函数                                     方法的入参和返回值
  def urlBuilder(ssl: Boolean = true, domain: String): ((String, String) => String) = {
    val schema = if (ssl) "https://" else "http://"
    (endpoint: String, query: String) => s"$schema$domain/$endpoint?$query"
  }

}
