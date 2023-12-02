package org.example.realworldapi;

import org.example.realworldapi.util.LibertyContainer;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.images.builder.ImageFromDockerfile;
import org.testcontainers.junit.jupiter.Container;

import java.nio.file.Paths;

public class AppDeploymentConfig {

    private static final ImageFromDockerfile realWorldImage
            = new ImageFromDockerfile("realworld:1.0-SNAPSHOT")
            .withDockerfile(Paths.get("./Dockerfile"));

    static Network n = Network.newNetwork();

    @Container
    public static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16.0").withDatabaseName("postgres_db").withPassword("S3cret").withUsername("postgres_user").withNetwork(n).withNetworkAliases("testpostgres");

//    TODO use same functionality!
//    .withAppContextRoot("/realworld-liberty")

    @Container
    public static LibertyContainer app = new LibertyContainer(realWorldImage, 9080, 9443)
            .withEnv("POSTGRESQL_HOSTNAME", "testpostgres").withEnv("POSTGRESQL_PORT", "5432").waitingFor(Wait.forHttp("/health/ready").forPort(9080)) .withLogConsumer(
                    new Slf4jLogConsumer(LoggerFactory.getLogger(LibertyContainer.class))).withNetwork(n).dependsOn(postgres);

}
