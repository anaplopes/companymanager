package br.com.b2b.companymanager.exception

import java.lang.RuntimeException

class NotFoundException(message: String?): RuntimeException(message) {
}