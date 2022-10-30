package xyz.gggedr.board.gamesbackend.utils

import java.util.*

class StringUtils {

    companion object {
        private const val NUMBERS = "0123456789"

        fun generateRandomString(length: Int): String {
            val random = Random()
            val sb = StringBuilder(length)
            for (i in 0 until length) {
                sb.append(NUMBERS[random.nextInt(NUMBERS.length)])
            }
            return sb.toString()
        }
    }

}