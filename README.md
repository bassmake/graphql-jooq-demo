# GraphQL with jOOQ

## Running

Run
```
./gradlew bootRun
```
and then go to `http://localhost:8080/graphiql`.

Sample query:
```graphql
query {
  shows {
    title
  }
}
```

## Technologies

- [kotlin](https://kotlinlang.org/) - Language
- [Spotless](https://github.com/diffplug/spotless/tree/main/plugin-gradle) - Gradle plugin
- [ktlint](https://ktlint.github.io/) - Kotlin linter
- [Spring Boot](https://spring.io/projects/spring-boot) - DI Framework
- [DGS Framework](https://netflix.github.io/dgs/) - GraphQL Framework
- [Liquibase](https://www.liquibase.org/) - version control for DB changes
- [jOOQ](https://www.jooq.org/) - type safe SQL

## TODO

Generate code using jOOQ and Liquibase. 