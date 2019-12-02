package kafka.stream;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KafkaStream {

    @Incoming("entrada")
    @Outgoing("saida")
    @Broadcast
    public String process(String data) {
        System.out.println(data);
        return data + " passou pelo quarkus";
    }

}
