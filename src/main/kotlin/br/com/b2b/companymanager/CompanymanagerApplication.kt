package br.com.b2b.companymanager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CompanyManagerApplication

fun main(args: Array<String>) {
	runApplication<CompanyManagerApplication>(*args)
}
