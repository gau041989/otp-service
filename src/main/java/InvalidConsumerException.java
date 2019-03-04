public class InvalidConsumerException extends Throwable {
    private String consumerId;

    public InvalidConsumerException(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getConsumerId() {
        return consumerId;
    }
}
