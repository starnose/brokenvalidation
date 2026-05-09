package com.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@MicronautTest
class EnumControllerSpec extends Specification{
    @Inject
    @Client("/")
    HttpClient client;

    def "we can hit the string endpoint with a status" () {
        when:
        String result = client.toBlocking().retrieve(HttpRequest.GET("/string?status=Active"), String.class);

        then:
        noExceptionThrown()
        result == "Active"
    }

    def "we can hit the string endpoint without a status" () {
        when:
        String result = client.toBlocking().retrieve(HttpRequest.GET("/string"), String.class);

        then:
        noExceptionThrown()
        result == "NULL"
    }

    def "we can hit the enum endpoint with a status" () {
        when:
        String result = client.toBlocking().retrieve(HttpRequest.GET("/enum?status=Active"), String.class);

        then:
        noExceptionThrown()
        result == "Active"
    }

    def "we can hit the enum endpoint without a status" () {
        when:
        String result = client.toBlocking().retrieve(HttpRequest.GET("/enum"), String.class);

        then:
        noExceptionThrown()
        result == "NULL"
    }
}
