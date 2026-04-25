package org.example

fun main() {
    val process = Runtime.getRuntime().exec("scrcpy --no-audio -s 39130DLJH002WY")
    val result = process.waitFor()
    println(result)
    //assertThat(result).isEqualTo(0)
}
