import java.util.UUID;

public class UUIDGenerator implements TransactionIdGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
