package br.com.b2b.companymanager.exception

import java.lang.RuntimeException

class BadRequestException(message: String?): RuntimeException(message) {
}