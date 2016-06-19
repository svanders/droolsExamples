appender('console', ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = "%d{HH:mm:ss.SSS} %-5level [%thread] - %msg%n"
  }
}

root(WARN, ["console"])

//logger("nz.edmi.drools.main.utils.DroolsLoader", DEBUG)
