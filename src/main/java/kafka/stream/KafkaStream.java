package kafka.stream;

import io.reactivex.Flowable;
import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class KafkaStream {

    private Random random = new Random();

    @Broadcast
    @Incoming("entrada")
    @Outgoing("saida")
    public String process(String data) {
        System.out.println(data);
        return data + " passou pelo quarkus";
    }

    @Broadcast
    @Outgoing("test")
    public Flowable<Integer> generate() {
        return Flowable.interval(1, TimeUnit.SECONDS)
                .map(tick -> random.nextInt(100));
    }

}
