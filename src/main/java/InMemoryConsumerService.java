import java.util.List;

public class InMemoryConsumerService implements ConsumerService {

    private final List<String> consumers;

    public InMemoryConsumerService(List<String> consumers) {
        this.consumers = consumers;
    }

    @Override
    public boolean validate(String consumerId) {
        return consumers.contains(consumerId);
    }
}
