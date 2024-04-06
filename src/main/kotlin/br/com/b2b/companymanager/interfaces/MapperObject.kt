package br.com.b2b.companymanager.interfaces

interface MapperObject<T, U> {

    fun map(t: T): U
}
