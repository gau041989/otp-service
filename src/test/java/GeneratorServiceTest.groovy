import spock.lang.Specification

class GeneratorServiceTest extends Specification {

    def otpStore = new InMemoryOtpStore()
    def transactionIdGenerator = Mock(TransactionIdGenerator)
    def consumerService = Mock(ConsumerService)

    def "should be able to create otp for a valid consumerId" () {
        given:
            transactionIdGenerator.generate() >> "1111"
            def consumerID = "12345"
            consumerService.validate(consumerID) >> true

        when:
            def unit = new GeneratorService(transactionIdGenerator, consumerService, otpStore)
            def transactionID = unit.generateOtp(consumerID)

        then:
            transactionID == "1111"
    }

    def "should store otp for a valid consumerId" () {
        given:
        def transactionID = "1111"
        transactionIdGenerator.generate() >> transactionID
        def consumerID = "12345"
        consumerService.validate(consumerID) >> true

        when:
        def unit = new GeneratorService(transactionIdGenerator, consumerService, otpStore)
        def actualTransactionId = unit.generateOtp(consumerID)

        then:
        //ToDo revisit this later
        otpStore.getOtp(new OtpKey(consumerID, actualTransactionId)) != null

    }

    def "should throw InvalidConsumerException for an invalid consumerId" () {
        given:
        def consumerID = "12345"

        when:
        def unit = new GeneratorService(transactionIdGenerator, consumerService, otpStore)
        unit.generateOtp(consumerID)

        then:
        InvalidConsumerException exception = thrown()
        exception.getConsumerId() == consumerID
    }
}
