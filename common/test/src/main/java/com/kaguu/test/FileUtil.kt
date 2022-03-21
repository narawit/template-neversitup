package com.kaguu.test

import java.io.IOException

object FileUtil {

    private fun getInputStreamFromResource(fileName: String) =
        javaClass.classLoader?.getResourceAsStream(fileName)

    @Throws(IOException::class)
    fun readJsonFile(fileName: String): String {

        return getInputStreamFromResource(fileName)?.bufferedReader()
            .use { bufferReader -> bufferReader?.readText() } ?: ""
    }

}