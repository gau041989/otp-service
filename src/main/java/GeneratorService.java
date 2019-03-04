public class GeneratorService {

    private TransactionIdGenerator transactionIdGenerator;
    private ConsumerService consumerService;
    private OtpStore otpStore;

    public GeneratorService(TransactionIdGenerator transactionIdGenerator, ConsumerService consumerService, OtpStore otpStore) {
        this.transactionIdGenerator = transactionIdGenerator;
        this.consumerService = consumerService;
        this.otpStore = otpStore;
    }

    public String generateOtp(String consumerId) throws InvalidConsumerException {
        if(consumerService.validate(consumerId)) {
            //store transId + consumerId ==> otpStore
            String generatedTransactionID = transactionIdGenerator.generate();
            otpStore.create(new OtpKey(consumerId, generatedTransactionID));
            return generatedTransactionID;
        }
        throw new InvalidConsumerException(consumerId);
    }
}
