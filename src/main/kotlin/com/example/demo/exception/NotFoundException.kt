package com.example.demo.exception

import java.lang.RuntimeException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * リソースが見つからない場合の例外クラス
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException(message: String?) : RuntimeException(message)
