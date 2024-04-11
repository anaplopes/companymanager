package br.com.b2b.companymanager.interfaces

interface IMapperObject<T, U> {

    fun map(t: T): U
}
