# Http Tracing with Zipkin and Open Telemetry
참고
* https://medium.com/@mertcakmak2/http-tracing-with-spring-boot-zipkin-and-open-telemetry-c12e4c599da4
* https://medium.com/@mertcakmak2/monitoring-spring-boot-microservices-prometheus-grafana-zipkin-6430b767795e
* opentelemetry-exporter-otlp : 1.33.0 버그로 인해 1.32.0 사용
```groovy
implementation 'io.opentelemetry:opentelemetry-exporter-otlp:1.32.0'
```
* 브릿지는 하나만 사용
```groovy
implementation 'io.micrometer:micrometer-tracing-bridge-brave:1.2.0'
// implementation 'io.micrometer:micrometer-tracing-bridge-otel:1.2.0'
```