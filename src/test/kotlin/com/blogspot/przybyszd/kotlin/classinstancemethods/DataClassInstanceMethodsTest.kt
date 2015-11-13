package com.blogspot.przybyszd.kotlin.classinstancemethods

import org.junit.Test
import kotlin.test.assertEquals

class DataClassInstanceMethodsTest {
    @Test
    fun componentsTest() {
        //when
        val p = Person("John", "Smith", 20)

        //then
        assertEquals("John", p.component1())
        assertEquals("Smith", p.component2())
        assertEquals(20, p.component3())
    }

    @Test
    fun extractingTest() {
        //when
        val (first, last, age) = Person("John", "Smith", 20)

        //then
        assertEquals(20, age)
        assertEquals("John", first)
        assertEquals("Smith", last)
    }

    @Test
    fun copyTest() {
        //when
        val person = Person("John", "Smith", 20).copy(lastName = "Kowalski", firstName = "Jan")

        //then
        assertEquals(Person("Jan", "Kowalski", 20), person)
    }
}