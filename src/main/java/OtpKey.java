public class OtpKey {
    private String consumerID;
    private String transactionID;

    public OtpKey(String consumerID, String transactionID) {
        this.consumerID = consumerID;
        this.transactionID = transactionID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OtpKey otpKey = (OtpKey) o;

        if (consumerID != null ? !consumerID.equals(otpKey.consumerID) : otpKey.consumerID != null) return false;
        return transactionID != null ? transactionID.equals(otpKey.transactionID) : otpKey.transactionID == null;
    }

    @Override
    public int hashCode() {
        int result = consumerID != null ? consumerID.hashCode() : 0;
        result = 31 * result + (transactionID != null ? transactionID.hashCode() : 0);
        return result;
    }
}
