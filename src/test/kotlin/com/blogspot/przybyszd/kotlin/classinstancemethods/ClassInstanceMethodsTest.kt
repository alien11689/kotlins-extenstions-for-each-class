package com.blogspot.przybyszd.kotlin.classinstancemethods

import org.junit.Test
import kotlin.test.assertEquals

class ClassInstanceMethodsTest {
    @Test
    fun applyTest() {
        //when
        val person = PersonJaxb().apply {
            firstName = "John"
            lastName = "Smith"
            age = 20
        }

        //then
        assertEquals(20, person.age)
        assertEquals("John", person.firstName)
        assertEquals("Smith", person.lastName)
    }

    @Test
    fun applyWithClosureTest() {
        //given
        val closure: PersonJaxb.() -> Unit = { ->
            firstName = "John"
            lastName = "Smith"
            age = 20
        }

        //when
        val person = PersonJaxb().apply(closure)

        //then
        assertEquals(20, person.age)
        assertEquals("John", person.firstName)
        assertEquals("Smith", person.lastName)
    }

    @Test
    fun letTest() {
        //when
        val fullName = Person("John", "Smith", 20).let {
            "${it.firstName} ${it.lastName}"
        }

        //then
        assertEquals("John Smith", fullName)
    }

    @Test
    fun letWithFunTest() {
        //given
        fun personToFullName(p: Person) = "${p.firstName} ${p.lastName}"

        //when
        val fullName = Person("John", "Smith", 20).let(::personToFullName)

        //then
        assertEquals("John Smith", fullName)
    }

    @Test
    fun runTest() {
        //when
        val fullName = Person("John", "Smith", 20).run {
            "$firstName $lastName"
        }

        //then
        assertEquals("John Smith", fullName)
    }

    @Test
    fun toTest() {
        //when
        val pair = Person("John", "Smith", 20) to 5

        //then
        assertEquals(Person("John", "Smith", 20), pair.first)
        assertEquals(5, pair.second)
    }

}