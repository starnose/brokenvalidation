package com.example;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;

import java.util.Optional;

@Controller("/")
public class EnumController {
  @Get("string")
  public String stringGet(@Nullable @QueryValue("status") String status) {
    return Optional.ofNullable(status).orElse("NULL");
  }

  @Get("enum")
  public String enumGet(@Nullable @QueryValue("status") StatusEnum status) {
    return Optional.ofNullable(status).map(StatusEnum::toString).orElse("NULL");
  }
}
