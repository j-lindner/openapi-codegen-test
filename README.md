# openapi-codegen-test

Small example project to run three basic tests that interact with C7 Open API Spec.

As the example provided upfront didn't work due to failing dateformat, I tried the following:

Instead of using the camunda-engine-rest-client-openapi-java[https://github.com/camunda-community-hub/camunda-platform-7-rest-client-java], I downloaded the current contract from https://docs.camunda.org/rest/camunda-bpm-platform/7.19/ and tried own configurations via openapi-generator-maven-plugin.
I tried different configurations

- generatorName=java, library=resttemplate, configOptions.dateLibrary=legacy
- generatorName=java, library=resttemplate, configOptions.dateLibrary=java8
- generatorName=java, library=native, configOptions.dateLibrary=legacy (with java version 11, as required for library=native)

All fail with an exception like
"java.lang.Exception: 400 : "{"type":"InvalidRequestException","message":"Cannot set query parameter 'after' to value '2023-03-23T08:19:08.173+00:00': Cannot convert value \"2023-03-23T08:19:08.173+00:00\" to java type java.util.Date","code":null}""
