package com.googlejobapp.testresources

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testFile() {
        val file = File("src/test/resources/hardToRead.json")
        assertTrue(file.exists())
        val string = file.readText()
        assertEquals("content length", 38, string.length)
    }

    @Test
    fun testClassLoaderResource() {
        val resource = javaClass.classLoader.getResource("hardToRead.json")
        assertNotNull(resource)
        val file = File(resource.file)
        assertTrue(file.exists())
        val string = file.readText()
        System.out.println("my string=$string")
        assertEquals("content length", 38, string.length)
    }

    @Test
    fun testClassLoaderResourceStream() {
        val stream = javaClass.classLoader.getResourceAsStream("hardToRead.json")
        assertNotNull(stream)
        val string = stream.bufferedReader().use { it.readText() }
        assertEquals("content length", 38, string.length)
    }
}
