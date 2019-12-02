package org.acme.kafka;

import org.apache.kafka.streams.kstream.KStream;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KafkaStream {

    private KStream<Object, Object> stream;

    public KafkaStream() {
        this.startStream();
    }

    public void startStream() {
        System.out.println("Iniciou!");
    }

    @Incoming("entrada")
    @Outgoing("saida")
    public String process(String data) {
        System.out.println(data);
        return data + " passou pelo quarkus";
    }

}
