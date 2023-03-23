package io.m_arc.camunda.test;

import com.camunda.openapi.api.DeploymentApi;
import com.camunda.openapi.invoker.ApiClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestClientException;

import java.io.File;
import java.time.OffsetDateTime;
import java.util.Date;

@SpringBootTest(classes = {CamundaInstanceTestApp.class, DeploymentApi.class, ApiClient.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DeploymentApiTest {
    private static ApiClient client = new ApiClient();
    private static DeploymentApi api = new DeploymentApi(client);

    @Test
    public void shouldCreateDeployment() throws Exception {
        String bpmnXmlPath = "processes/start_end.bpmn";
        api.createDeployment(
                null,
                null,
                true,
                true,
                "benchmark",
                null,
                new File(DeploymentApiTest.class.getClassLoader().getResource(bpmnXmlPath).getFile()));
    }


    @Test
    public void shouldGetDeployments() throws Exception {
        api.getDeployments(null, null, null, null, null, null, null, null, new Date(), null, null, null, null, null);
    }

    @Test
    public void shouldGetDeploymentsWithMessage() throws Exception {
        try {
            api.getDeployments(null, null, null, null, null, null, null, null, new Date(), null, null, null, null,
                    null);
        } catch (RestClientException e) {
            throw new Exception(e.getMessage());
        }
    }
}
